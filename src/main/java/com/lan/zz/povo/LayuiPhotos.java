package com.lan.zz.povo;

import java.util.Arrays;

public class LayuiPhotos {

    public static class LayuiImage{
        private String alt;
        private Integer pid;
        private String src;
        private String thumb;

        @Override
        public String toString() {
            return "LayuiImage{" +
                    "alt='" + alt + '\'' +
                    ", pid=" + pid +
                    ", src='" + src + '\'' +
                    ", thumb='" + thumb + '\'' +
                    '}';
        }

        public LayuiImage() {

        }

        public LayuiImage(String alt, String src) {
            this.pid = 1;
            this.thumb = "";
            this.alt = alt;
            this.src = src;
        }

        public LayuiImage(String alt, Integer pid, String src, String thumb) {
            this.alt = alt;
            this.pid = pid;
            this.src = src;
            this.thumb = thumb;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public Integer getPid() {
            return pid;
        }

        public void setPid(Integer pid) {
            this.pid = pid;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }

    private String title;
    private Integer id;
    private Integer start;
    private LayuiImage[] data;


    public LayuiPhotos() {

    }

    @Override
    public String toString() {
        return "LayuiPhotos{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", start=" + start +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public LayuiPhotos(LayuiImage[] data) {
        this.id = 0;
        this.start = 0;
        this.title = "";
        this.data = data;
    }

    public LayuiPhotos(String title, Integer id, Integer start, LayuiImage[] data) {
        this.title = title;
        this.id = id;
        this.start = start;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public LayuiImage[] getData() {
        return data;
    }

    public void setData(LayuiImage[] data) {
        this.data = data;
    }
}
