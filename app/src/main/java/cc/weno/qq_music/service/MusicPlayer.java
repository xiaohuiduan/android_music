package cc.weno.qq_music.service;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class MusicPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener {

    private MediaPlayer mediaPlayer;
    private static MusicPlayer musicPlayer;


    public  MusicPlayer getInstance(){
        if (musicPlayer == null) {
            musicPlayer = new MusicPlayer();
            musicPlayer.mediaPlayer = new MediaPlayer();
            musicPlayer.mediaPlayer.setOnBufferingUpdateListener(this);
            musicPlayer.mediaPlayer.setOnPreparedListener(this);
        }
        return musicPlayer;
    }

    public void display(String url){
        Log.d(TAG, "display: "+url);
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(url);
//            由于加载的是网络资源，所以不能直接使用start
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        mediaPlayer.start();
    }
    // 暂停
    public void pause() {
        mediaPlayer.pause();
    }



    /**
     * 播放准备
     *
     * @param mediaPlayer
     */
    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    /**
     * 播放完成
     * @param mediaPlayer
     * @param i
     */
    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {

    }

    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    public void seekTo(int progress) {
        mediaPlayer.seekTo(progress);
    }
}
