package cc.weno.qq_music;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

import cc.weno.qq_music.music_util.dao.SongImgDao;
import cc.weno.qq_music.music_util.dao.SongListDao;
import cc.weno.qq_music.music_util.net.AsyncRequest;
import cc.weno.qq_music.music_util.net.got.GetSong;
import cc.weno.qq_music.music_util.net.got.GetSongImg;
import cc.weno.qq_music.service.MusicPlayer;
import cc.weno.qq_music.service.MusicService;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Button button;
    private ImageView songImg;
    private static MusicService musicService;
    private String url;
    private SeekBar seekBar;
    private TextView positionTime;
    private TextView totalTime;
    private String TAG = ">>>>>>>>";
    private String albummid;
    private String singerMid;
    private boolean isPlay = false;
    private static MusicService.MyBinder binder = null;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            Bitmap bitmap = data.getParcelable("img");
            songImg.setImageBitmap(bitmap);
            songImg.setAnimation(AnimationUtils.loadAnimation(MusicActivity.this, R.anim.img_amination));
        }
    };

    private String albumImgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        url = getIntent().getStringExtra("url");
        albummid = getIntent().getStringExtra("albummid");
        singerMid = getIntent().getStringExtra("singerMid");
        // 将图片进行展示
        getImg(albummid, singerMid);
        init();
    }

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder = (MusicService.MyBinder) iBinder;
            if (MusicActivity.musicService == null) {
                MusicActivity.musicService = ((MusicService.MyBinder) iBinder).getService();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            MusicActivity.musicService = null;
        }
    };

    /**
     * init the music service
     */
    private void initService(String url) {
        if (MusicActivity.binder == null) {
            Intent intent = new Intent(this, MusicService.class);
            intent.putExtra("url", url);
            startService(intent);
            bindService(intent, sc, BIND_AUTO_CREATE);
        } else {
            MusicActivity.binder.setData(url);
        }
        isPlay = true;
    }


    private void init() {
        button = findViewById(R.id.play_music);
        button.setOnClickListener(this);
        songImg = findViewById(R.id.d_song_img);

        seekBar = findViewById(R.id.seek_bar);
        positionTime = findViewById(R.id.now_time);
        totalTime = findViewById(R.id.total_time);
        seekBar.setOnSeekBarChangeListener(this);

        GetSong getSong = new GetSong(url);
        AsyncTask asyncTask = new AsyncRequest().execute(getSong);
        try {
            SongListDao songListDao = (SongListDao) asyncTask.get();
            initService(songListDao.getData().get(0));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * 获得歌曲的图片
     *
     * @param albummid
     * @param singerMid
     */
    private void getImg(String albummid, String singerMid) {
        AsyncTask getImgTask = new AsyncRequest().execute(new GetSongImg(albummid, singerMid));
        try {
            SongImgDao songImgDao = (SongImgDao) getImgTask.get();
            if (songImgDao != null) {
                initImg(songImgDao.getData().getAlbumImgUrl());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initImg(String albumImgUrl) {
        this.albumImgUrl = albumImgUrl;
        new Thread(networkTask).start();
    }

    /**
     * 获得网络的照片并进行展示
     */
    Runnable networkTask = new Runnable() {

        @Override
        public void run() {
            Message msg = new Message();
            Bundle data = new Bundle();
            data.putParcelable("img", toRoundCornerImage(getImageBitmap(albumImgUrl), 360));
            msg.setData(data);
            handler.sendMessage(msg);
        }

    };

    @Override
    public void onClick(View view) {
        MusicPlayer musicPlayer = new MusicPlayer().getInstance();
        seekBar.setProgress(musicPlayer.getCurrentPosition());
        seekBar.setMax(musicPlayer.getDuration());
        int totalTimeInt = Math.round(musicPlayer.getDuration() / 1000);
        String total = String.format("%02d:%02d", totalTimeInt / 60, totalTimeInt % 60);
        int currentTimeInt = Math.round(musicPlayer.getCurrentPosition() / 1000);
        String position = String.format("%02d:%02d", currentTimeInt / 60, currentTimeInt % 60);
        positionTime.setText(position);
        totalTime.setText(total);
        if (isPlay) {
            new MusicPlayer().getInstance().pause();
            button.setText("暂停中");
        } else {
            new MusicPlayer().getInstance().start();
            button.setText("播放中");
        }
        isPlay = !isPlay;

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        MusicPlayer musicPlayer = new MusicPlayer().getInstance();
        if(!b){
            Log.d(TAG, "onProgressChanged: >>>>>>>>");
        }
        if (b) {
            musicPlayer.seekTo(seekBar.getProgress());
            int currentTime = Math.round(musicPlayer.getCurrentPosition() / 1000);
            String currentStr = String.format("%02d:%02d",currentTime / 60, currentTime % 60);
            positionTime.setText(currentStr);
        }
    }

    private Bitmap getImageBitmap(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e(TAG, "Error getting bitmap", e);
        }
        return bm;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * 获取圆角位图的方法
     *
     * @param bitmap 需要转化成圆角的位图
     * @param pixels 圆角的度数，数值越大，圆角越大
     * @return 处理后的圆角位图
     */
    public static Bitmap toRoundCornerImage(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;
        // 抗锯齿
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }
}
