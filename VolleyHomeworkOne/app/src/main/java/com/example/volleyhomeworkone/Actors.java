package com.example.volleyhomeworkone;

class Actors {
    private String id, actorName, imageUrl, movieName;

    Actors(String id, String actorName, String imageUrl, String movieName) {
        this.id = id;
        this.actorName = actorName;
        this.imageUrl = imageUrl;
        this.movieName = movieName;
    }

    String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
