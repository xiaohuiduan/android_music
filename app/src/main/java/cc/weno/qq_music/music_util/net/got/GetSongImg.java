package cc.weno.qq_music.music_util.net.got;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;

import cc.weno.qq_music.music_util.ApiStaticMsg;
import cc.weno.qq_music.music_util.dao.SongImgDao;
import cc.weno.qq_music.music_util.dao.SongListDao;
import cc.weno.qq_music.music_util.net.ProcessInterface;

public class GetSongImg implements ProcessInterface {
    // 歌曲所属的专辑的媒体 id
    private String albummid;

    // 歌手的媒体 id
    private String singerMid;

    public GetSongImg(String albummid, String singerMid) {
        this.albummid = albummid;
        this.singerMid = singerMid;
    }

    @Override
    public Object call() {
        HttpRequest request = HttpRequest.get(String.format(ApiStaticMsg.SONG_IMG + "%s/%s/", albummid, singerMid));

        //Accept all certificates
        request.trustAllCerts();
        //Accept all hostnames
        request.trustAllHosts();
        try {
            SongImgDao songImgDao = JSONObject.parseObject(request.body(), SongImgDao.class);
            return songImgDao;
        } catch (Exception e) {
            return null;
        }

    }
}
