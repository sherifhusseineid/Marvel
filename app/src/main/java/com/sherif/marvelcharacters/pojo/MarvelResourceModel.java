package com.sherif.marvelcharacters.pojo;

import com.google.gson.annotations.SerializedName;

public class MarvelResourceModel {

    @SerializedName("resourceURI") private String resourceUri;
    @SerializedName("name") private String name;

    public String getResourceUri() {
        return resourceUri;
    }

    public String getName() {
        return name;
    }

    @Override public String toString() {
        return "MarvelResourceDto{"
                + "resourceUri='"
                + resourceUri
                + '\''
                + ", name='"
                + name
                + '\''
                + '}';
    }
}
