package org.donstu.domain;

import java.io.Serializable;

public class Place implements Serializable {
    private String hall;
    private int row;
    private int place;

    public Place() {
    }

    public Place(String hall, int row, int place) {
        this.hall = hall;
        this.row = row;
        this.place = place;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Place{" +
                "hall='" + hall + '\'' +
                ", row=" + row +
                ", place=" + place +
                '}';
    }
}
