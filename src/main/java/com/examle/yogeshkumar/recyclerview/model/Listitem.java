package com.examle.yogeshkumar.recyclerview.model;

/**
 * Created by Yogesh Kumar on 2/14/2017.
 */

public class Listitem {

    private String subTitle;
    private boolean favourite=false;
   private String title;
    private int imageresid;

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageresid() {
        return imageresid;
    }

    public void setImageresid(int imageresid) {
        this.imageresid = imageresid;
    }
}
