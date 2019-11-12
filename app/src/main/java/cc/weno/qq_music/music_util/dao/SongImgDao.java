package cc.weno.qq_music.music_util.dao;

public class SongImgDao {

    @Override
    public String toString() {
        return "SongImgDao{" +
                "announce='" + announce + '\'' +
                ", errno=" + errno +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * announce : 本接口所有数据均来自 QQ 音乐, 仅供学习交流之用,请不要用于商业用途. 如果喜欢请下载 QQ 音乐 APP 畅听.如有侵权请联系微信(QQ): 1363693666, 我会第一时间删除~
     * errno : 0
     * msg : success
     * data : {"albumImgUrl":"https://y.gtimg.cn/music/photo_new/T002R300x300M000002CWEnV2g4m3p.jpg","singerAvatarUrl":"https://y.gtimg.cn/music/photo_new/T001R150x150M000001oXbjs29oPul.jpg"}
     */

    private String announce;
    private int errno;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * albumImgUrl : https://y.gtimg.cn/music/photo_new/T002R300x300M000002CWEnV2g4m3p.jpg
         * singerAvatarUrl : https://y.gtimg.cn/music/photo_new/T001R150x150M000001oXbjs29oPul.jpg
         */

        private String albumImgUrl;
        private String singerAvatarUrl;

        public String getAlbumImgUrl() {
            return albumImgUrl;
        }

        public void setAlbumImgUrl(String albumImgUrl) {
            this.albumImgUrl = albumImgUrl;
        }

        public String getSingerAvatarUrl() {
            return singerAvatarUrl;
        }

        public void setSingerAvatarUrl(String singerAvatarUrl) {
            this.singerAvatarUrl = singerAvatarUrl;
        }
    }
}
