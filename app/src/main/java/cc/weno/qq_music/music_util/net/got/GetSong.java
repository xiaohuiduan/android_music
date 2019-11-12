package cc.weno.qq_music.music_util.net.got;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;

import cc.weno.qq_music.music_util.ApiStaticMsg;
import cc.weno.qq_music.music_util.dao.SearchResultDao;
import cc.weno.qq_music.music_util.dao.SongListDao;
import cc.weno.qq_music.music_util.net.ProcessInterface;

public class GetSong implements ProcessInterface {
    private String songMidId;

    public GetSong(String songMidId) {
        this.songMidId = songMidId;
    }

    @Override
    public Object call() {


        HttpRequest request = HttpRequest.get(ApiStaticMsg.SONG_LIST+songMidId);
        //Accept all certificates
        request.trustAllCerts();
        //Accept all hostnames
        request.trustAllHosts();
        SongListDao resultDao = JSONObject.parseObject(request.body(), SongListDao.class);
        return resultDao;
    }
}