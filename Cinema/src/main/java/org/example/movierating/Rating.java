package org.example.movierating;

public enum Rating {
    G(1),
    PG(2),
    PG_13(3),
    R(4),
    NC_17(5);

    private final int ratingCode;

    Rating(int ratingCode) {
        this.ratingCode = ratingCode;
    }

    public int getRatingCode() {
        return ratingCode;
    }
}
