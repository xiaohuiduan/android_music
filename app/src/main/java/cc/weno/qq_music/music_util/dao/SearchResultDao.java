package cc.weno.qq_music.music_util.dao;

import java.util.List;

public class SearchResultDao {

    @Override
    public String toString() {
        return "SearchResultDao{" +
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
     * data : {"page":{"currentNumber":20,"currentPage":1,"totalNumber":583},"songList":[{"songMid":"000zw2SJ4cgYK6","singer":[{"singerName":"孙子涵","singerMid":"001oXbjs29oPul"}],"songName":"唐人","songId":4884605,"albumMid":"0005Tj2O2ZpK0Q"},{"songMid":"004R8G313lq4Es","singer":[{"singerName":"孙子涵","singerMid":"001oXbjs29oPul"}],"songName":"唐人（DJ版）","songId":124798903,"albumMid":""},{"songMid":"004WyY6b1pb8Cc","singer":[{"singerName":"摩登兄弟","singerMid":"001KH1tJ02U8KY"}],"songName":"唐人","songId":126218160,"albumMid":""},{"songMid":"000IyZ2o08NFhX","singer":[{"singerName":"DJ","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人 (DJ颜妹)","songId":125787696,"albumMid":""},{"songMid":"0038ccYJ0na7Ty","singer":[{"singerName":"韩夏夏;雪儿","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人","songId":121582792,"albumMid":""},{"songMid":"0037gNxp3y5Piq","singer":[{"singerName":"孙子涵","singerMid":"001oXbjs29oPul"}],"songName":"唐人 (Live)","songId":4985065,"albumMid":"003GnBWV37roLn"},{"songMid":"000hQs1d3FoyI7","singer":[{"singerName":"毛惠","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人","songId":126432321,"albumMid":""},{"songMid":"002Kgubo3wLGeP","singer":[{"singerName":"DJ奶小深","singerMid":"003cK3Nh0WkFO4"}],"songName":"唐人 (中文电摇)","songId":202030880,"albumMid":"003clRXQ2zegpA"},{"songMid":"002lSBQe36rj09","singer":[{"singerName":"文儿","singerMid":"002vWQPi11Ee9K"}],"songName":"唐人","songId":200389493,"albumMid":"001Bet0G1DO2mU"},{"songMid":"003vgZDS20RQ1a","singer":[{"singerName":"潇小潇","singerMid":"001VlqIl4HJNxo"}],"songName":"唐人","songId":204537591,"albumMid":"0033FmTg3OX3lP"},{"songMid":"002TmppY1ePBwr","singer":[{"singerName":"东子陌","singerMid":"003xz8RE3iGFIN"}],"songName":"唐人 (抖音版)","songId":223040570,"albumMid":"0040xTRG1aq5BO"},{"songMid":"003KPYwI2gr819","singer":[{"singerName":"五音Jw","singerMid":"003jUuqU2AhYos"}],"songName":"唐人","songId":213026010,"albumMid":"001ZaCQY2OxVMg"},{"songMid":"002sIhlL3Ti5xn","singer":[{"singerName":"小天宇","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人 (小黄人版)","songId":125843227,"albumMid":""},{"songMid":"001K7NS03hbrk4","singer":[{"singerName":"网络歌手","singerMid":"003WyUfh2uKIjh"}],"songName":"唐人","songId":104418380,"albumMid":"001ZaCQY2OxVMg"},{"songMid":"002MOysV3jO00C","singer":[{"singerName":"Dj Dvir Halevi","singerMid":"000ZuMAj2mAdxv"}],"songName":"唐人 (DJ阿满版)","songId":125602174,"albumMid":""},{"songMid":"000VPI1X3WE7ol","singer":[{"singerName":"尚士达","singerMid":"002pBrXg1l7ozA"}],"songName":"唐人 (Live)","songId":127340018,"albumMid":""},{"songMid":"0044s7Z14Vy1nk","singer":[{"singerName":"风小筝（覃沐曦）","singerMid":"000uDR5P30kU8Z"}],"songName":"唐人","songId":200620180,"albumMid":"001ZaCQY2OxVMg"},{"songMid":"","singer":[{"singerName":"孙子涵","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人 (铃声)","songId":0,"albumMid":""},{"songMid":"0024LyYv3cvjJ0","singer":[{"singerName":"冷凡","singerMid":"0023XArn1QuVjR"}],"songName":"唐人","songId":202976513,"albumMid":"003UU2RX3OolaZ"},{"songMid":"000LvaTp2qgVBt","singer":[{"singerName":"四郎","singerMid":"000IcDFx2F57D6"}],"songName":"唐人（Cover：群星）","songId":243016827,"albumMid":"004Z4bTQ3pCkH5"}]}
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
         * page : {"currentNumber":20,"currentPage":1,"totalNumber":583}
         * songList : [{"songMid":"000zw2SJ4cgYK6","singer":[{"singerName":"孙子涵","singerMid":"001oXbjs29oPul"}],"songName":"唐人","songId":4884605,"albumMid":"0005Tj2O2ZpK0Q"},{"songMid":"004R8G313lq4Es","singer":[{"singerName":"孙子涵","singerMid":"001oXbjs29oPul"}],"songName":"唐人（DJ版）","songId":124798903,"albumMid":""},{"songMid":"004WyY6b1pb8Cc","singer":[{"singerName":"摩登兄弟","singerMid":"001KH1tJ02U8KY"}],"songName":"唐人","songId":126218160,"albumMid":""},{"songMid":"000IyZ2o08NFhX","singer":[{"singerName":"DJ","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人 (DJ颜妹)","songId":125787696,"albumMid":""},{"songMid":"0038ccYJ0na7Ty","singer":[{"singerName":"韩夏夏;雪儿","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人","songId":121582792,"albumMid":""},{"songMid":"0037gNxp3y5Piq","singer":[{"singerName":"孙子涵","singerMid":"001oXbjs29oPul"}],"songName":"唐人 (Live)","songId":4985065,"albumMid":"003GnBWV37roLn"},{"songMid":"000hQs1d3FoyI7","singer":[{"singerName":"毛惠","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人","songId":126432321,"albumMid":""},{"songMid":"002Kgubo3wLGeP","singer":[{"singerName":"DJ奶小深","singerMid":"003cK3Nh0WkFO4"}],"songName":"唐人 (中文电摇)","songId":202030880,"albumMid":"003clRXQ2zegpA"},{"songMid":"002lSBQe36rj09","singer":[{"singerName":"文儿","singerMid":"002vWQPi11Ee9K"}],"songName":"唐人","songId":200389493,"albumMid":"001Bet0G1DO2mU"},{"songMid":"003vgZDS20RQ1a","singer":[{"singerName":"潇小潇","singerMid":"001VlqIl4HJNxo"}],"songName":"唐人","songId":204537591,"albumMid":"0033FmTg3OX3lP"},{"songMid":"002TmppY1ePBwr","singer":[{"singerName":"东子陌","singerMid":"003xz8RE3iGFIN"}],"songName":"唐人 (抖音版)","songId":223040570,"albumMid":"0040xTRG1aq5BO"},{"songMid":"003KPYwI2gr819","singer":[{"singerName":"五音Jw","singerMid":"003jUuqU2AhYos"}],"songName":"唐人","songId":213026010,"albumMid":"001ZaCQY2OxVMg"},{"songMid":"002sIhlL3Ti5xn","singer":[{"singerName":"小天宇","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人 (小黄人版)","songId":125843227,"albumMid":""},{"songMid":"001K7NS03hbrk4","singer":[{"singerName":"网络歌手","singerMid":"003WyUfh2uKIjh"}],"songName":"唐人","songId":104418380,"albumMid":"001ZaCQY2OxVMg"},{"songMid":"002MOysV3jO00C","singer":[{"singerName":"Dj Dvir Halevi","singerMid":"000ZuMAj2mAdxv"}],"songName":"唐人 (DJ阿满版)","songId":125602174,"albumMid":""},{"songMid":"000VPI1X3WE7ol","singer":[{"singerName":"尚士达","singerMid":"002pBrXg1l7ozA"}],"songName":"唐人 (Live)","songId":127340018,"albumMid":""},{"songMid":"0044s7Z14Vy1nk","singer":[{"singerName":"风小筝（覃沐曦）","singerMid":"000uDR5P30kU8Z"}],"songName":"唐人","songId":200620180,"albumMid":"001ZaCQY2OxVMg"},{"songMid":"","singer":[{"singerName":"孙子涵","singerMid":"0032fmHO2UDnV3"}],"songName":"唐人 (铃声)","songId":0,"albumMid":""},{"songMid":"0024LyYv3cvjJ0","singer":[{"singerName":"冷凡","singerMid":"0023XArn1QuVjR"}],"songName":"唐人","songId":202976513,"albumMid":"003UU2RX3OolaZ"},{"songMid":"000LvaTp2qgVBt","singer":[{"singerName":"四郎","singerMid":"000IcDFx2F57D6"}],"songName":"唐人（Cover：群星）","songId":243016827,"albumMid":"004Z4bTQ3pCkH5"}]
         */

        private PageBean page;
        private List<SongListBean> songList;

        @Override
        public String toString() {
            return "DataBean{" +
                    "page=" + page +
                    ", songList=" + songList +
                    '}';
        }

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<SongListBean> getSongList() {
            return songList;
        }

        public void setSongList(List<SongListBean> songList) {
            this.songList = songList;
        }

        public static class PageBean {
            @Override
            public String toString() {
                return "PageBean{" +
                        "currentNumber=" + currentNumber +
                        ", currentPage=" + currentPage +
                        ", totalNumber=" + totalNumber +
                        '}';
            }

            /**
             * currentNumber : 20
             * currentPage : 1
             * totalNumber : 583
             */

            private int currentNumber;
            private int currentPage;
            private int totalNumber;

            public int getCurrentNumber() {
                return currentNumber;
            }

            public void setCurrentNumber(int currentNumber) {
                this.currentNumber = currentNumber;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getTotalNumber() {
                return totalNumber;
            }

            public void setTotalNumber(int totalNumber) {
                this.totalNumber = totalNumber;
            }
        }

        public static class SongListBean {
            @Override
            public String toString() {
                return "SongListBean{" +
                        "songMid='" + songMid + '\'' +
                        ", songName='" + songName + '\'' +
                        ", songId=" + songId +
                        ", albumMid='" + albumMid + '\'' +
                        ", singer=" + singer +
                        '}';
            }

            /**
             * songMid : 000zw2SJ4cgYK6
             * singer : [{"singerName":"孙子涵","singerMid":"001oXbjs29oPul"}]
             * songName : 唐人
             * songId : 4884605
             * albumMid : 0005Tj2O2ZpK0Q
             */

            private String songMid;
            private String songName;
            private int songId;
            private String albumMid;
            private List<SingerBean> singer;

            public String getSongMid() {
                return songMid;
            }

            public void setSongMid(String songMid) {
                this.songMid = songMid;
            }

            public String getSongName() {
                return songName;
            }

            public void setSongName(String songName) {
                this.songName = songName;
            }

            public int getSongId() {
                return songId;
            }

            public void setSongId(int songId) {
                this.songId = songId;
            }

            public String getAlbumMid() {
                return albumMid;
            }

            public void setAlbumMid(String albumMid) {
                this.albumMid = albumMid;
            }

            public List<SingerBean> getSinger() {
                return singer;
            }

            public void setSinger(List<SingerBean> singer) {
                this.singer = singer;
            }

            public static class SingerBean {
                @Override
                public String toString() {
                    return "SingerBean{" +
                            "singerName='" + singerName + '\'' +
                            ", singerMid='" + singerMid + '\'' +
                            '}';
                }

                /**
                 * singerName : 孙子涵
                 * singerMid : 001oXbjs29oPul
                 */

                private String singerName;
                private String singerMid;

                public String getSingerName() {
                    return singerName;
                }

                public void setSingerName(String singerName) {
                    this.singerName = singerName;
                }

                public String getSingerMid() {
                    return singerMid;
                }

                public void setSingerMid(String singerMid) {
                    this.singerMid = singerMid;
                }
            }
        }
    }
}
