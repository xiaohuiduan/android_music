package cc.weno.qq_music.music_util.dao;

import java.util.List;

public class SongListDao {

    /**
     * announce : 本接口所有数据均来自 QQ 音乐, 仅供学习交流之用,请不要用于商业用途. 如果喜欢请下载 QQ 音乐 APP 畅听.如有侵权请联系微信(QQ): 1363693666, 我会第一时间删除~
     * errno : 0
     * msg : success
     * data : ["http://isure.stream.qqmusic.qq.com//C400002qayVx1bMMn2.m4a?guid=5579254314&vkey=BC32D357A5144401360BC74EB9992D069AFAD48A4D461E626F1A7000ABE7844343F73A17059B47F454838B0329A4D6C9E7C4A7B0B46EF7F8&uin=0&fromtag=38"]
     */

    private String announce;
    private int errno;
    private String msg;
    private List<String> data;

    public String getAnnounce() {
        return announce;
    }

    public void setAnnounce(String announce) {
        this.announce = announce;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
