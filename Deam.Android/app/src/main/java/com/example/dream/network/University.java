package com.example.dream.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class University {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private int name;
    @SerializedName("image")
    @Expose
    private int image;
    @SerializedName("cityId")
    @Expose
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
