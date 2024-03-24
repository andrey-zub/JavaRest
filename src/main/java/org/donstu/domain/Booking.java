package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class Booking implements Serializable {
    private Show show;

    private List<Place> places;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
