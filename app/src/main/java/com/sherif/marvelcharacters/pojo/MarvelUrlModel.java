package com.sherif.marvelcharacters.pojo;

import com.google.gson.annotations.SerializedName;

public class MarvelUrlModel {
    @SerializedName("type") private String type;
    @SerializedName("url") private String url;

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Override public String toString() {
        return "MarvelUrl{" + "type='" + type + '\'' + ", url='" + url + '\'' + '}';
    }
}
