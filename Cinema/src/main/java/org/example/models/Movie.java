package org.example.models;

import org.example.movierating.Rating;

public class Movie {
    private String title;
    private int length;
    private Rating rating;

    public Movie() {}

    public Movie(String title, int length, Rating rating) {
        this.title = title;
        this.length = length;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", length=" + length +
                ", rating=" + rating +
                '}';
    }
}
