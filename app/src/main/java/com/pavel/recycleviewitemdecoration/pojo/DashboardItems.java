package com.pavel.recycleviewitemdecoration.pojo;

public class DashboardItems {

    public String title;
    public int imageId;
    public int id;


    public DashboardItems(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
