package com.sherif.marvelcharacters.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterModel {

    @SerializedName("id") private String id;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("modified") private String modified;
    @SerializedName("resourceURI") private String resourceUri;
    @SerializedName("urls") private List<MarvelUrlModel> urls;
    @SerializedName("thumbnail")  private MarvelImageModel thumbnail;
    @SerializedName("comics") private MarvelResources<ComicResourceModel> comics;
    @SerializedName("stories") private MarvelResources<StoryResourceModel> stories;
    @SerializedName("events") private MarvelResources<EventResourceModel> events;
    @SerializedName("series") private MarvelResources<SerieResourceModel> series;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public List<MarvelUrlModel> getUrls() {
        return urls;
    }

    public MarvelImageModel getThumbnail() {
        return thumbnail;
    }

    public MarvelResources<ComicResourceModel> getComics() {
        return comics;
    }

    public MarvelResources<StoryResourceModel> getStories() {
        return stories;
    }

    public MarvelResources<EventResourceModel> getEvents() {
        return events;
    }

    public MarvelResources<SerieResourceModel> getSeries() {
        return series;
    }

    @Override public String toString() {
        return "CharacterDto{"
                + "id='"
                + id
                + '\''
                + ", name='"
                + name
                + '\''
                + ", description='"
                + description
                + '\''
                + ", modified='"
                + modified
                + '\''
                + ", resourceUri='"
                + resourceUri
                + '\''
                + ", urls="
                + urls
                + ", thumbnail="
                + thumbnail
                + ", comics="
                + comics
                + ", stories="
                + stories
                + ", events="
                + events
                + ", series="
                + series
                +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public void setUrls(List<MarvelUrlModel> urls) {
        this.urls = urls;
    }

    public void setThumbnail(MarvelImageModel thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setComics(MarvelResources<ComicResourceModel> comics) {
        this.comics = comics;
    }

    public void setStories(MarvelResources<StoryResourceModel> stories) {
        this.stories = stories;
    }

    public void setEvents(MarvelResources<EventResourceModel> events) {
        this.events = events;
    }

    public void setSeries(MarvelResources<SerieResourceModel> series) {
        this.series = series;
    }
}
