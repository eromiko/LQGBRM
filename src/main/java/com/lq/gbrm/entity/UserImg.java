package com.lq.gbrm.entity;

import java.sql.Blob;

public class UserImg {
    private Blob Img;

    public Blob getImg() {
        return Img;
    }

    public void setImg(Blob img) {
        Img = img;
    }

    public UserImg(Blob img) {
        Img = img;
    }
}
