package cc.weno.qq_music.music_util.net.got;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

import cc.weno.qq_music.music_util.ApiStaticMsg;
import cc.weno.qq_music.music_util.dao.SearchResultDao;
import cc.weno.qq_music.music_util.net.ProcessInterface;

import static android.content.ContentValues.TAG;

public class SearchSong implements ProcessInterface {
    private String songName;

    public SearchSong(String songName) {
        this.songName = songName;
    }

    @Override
    public Object call() {


        HttpRequest request = HttpRequest.get(ApiStaticMsg.SEARCH_KEY+songName);
        //Accept all certificates
        request.trustAllCerts();
        //Accept all hostnames
        request.trustAllHosts();
        SearchResultDao resultDao = JSONObject.parseObject(request.body(),SearchResultDao.class);
        return resultDao;
    }
}
