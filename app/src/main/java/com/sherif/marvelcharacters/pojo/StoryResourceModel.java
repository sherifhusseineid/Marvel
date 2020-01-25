package com.sherif.marvelcharacters.pojo;

import com.google.gson.annotations.SerializedName;

public class StoryResourceModel extends MarvelResourceModel {
    @SerializedName("type") private String type;

    public String getType() {
        return type;
    }

    @Override public String toString() {
        return "StoryResourceDto{"
                + "name="
                + super.getName()
                + "resourceUri="
                + super.getResourceUri()
                + "type='"
                + type
                + '\''
                +
                '}';
    }
}
