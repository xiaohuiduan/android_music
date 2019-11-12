package cc.weno.qq_music.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


/**
 * @author xiaohui
 */
public class MusicService extends Service {

    public MusicPlayer musicPlayer;
    private static MusicService musicService;

    /**
     * 当服务被创建时调用.
     */
    @Override
    public void onCreate() {

    }

    public static MusicService getInstance() {
        if (musicService == null) {
            musicService = new MusicService();
        }
        return musicService;
    }

    /**
     * 调用startService()启动服务时回调
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        musicPlayer = new MusicPlayer().getInstance();
        musicPlayer.display(intent.getStringExtra("url"));
        return startId;
    }

    /**
     * 通过bindService()绑定到服务的客户端
     */
    @Override
    public IBinder onBind(Intent intent) {

        return binder;
    }

    /**
     * 通过unbindService()解除所有客户端绑定时调用
     */
    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

    /**
     * 通过bindService()将客户端绑定到服务时调用
     */
    @Override
    public void onRebind(Intent intent) {

    }

    /**
     * 服务不再有用且将要被销毁时调用
     */
    @Override
    public void onDestroy() {

    }

    public final IBinder binder = new MyBinder();

    public class MyBinder extends Binder {
        public MusicService getService() {

            return MusicService.getInstance();
        }

        public void setData(String url){
            new MusicPlayer().getInstance().display(url);
        }
    }

}



