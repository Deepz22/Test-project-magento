package com.example.subhashvaikunth.testproject2;

import android.widget.ImageView;
import android.widget.ProgressBar;


public class ImgViewAndPath {

    private ImageView imageView;
    private String path;
    private ProgressBar pb;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {

        this.imageView = imageView;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public ProgressBar getPb() {
        return pb;
    }

    public void setPb(ProgressBar pb) {
        this.pb = pb;
    }
}
