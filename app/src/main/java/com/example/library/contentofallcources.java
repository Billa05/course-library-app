package com.example.library;

public class contentofallcources {
    private int id;
    private String Duration;
    private String Creator;
    private String name;
    private String url;
    private String imageUrl;

    public contentofallcources(int id, String duration, String creator, String name, String url, String imageUrl) {
        this.id = id;
        Duration = duration;
        Creator = creator;
        this.name = name;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "contentofallcources{" +
                "id=" + id +
                ", Duration='" + Duration + '\'' +
                ", Creator='" + Creator + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

