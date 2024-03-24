package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class Theatre implements Serializable {
    private List<Show> shows;

    private List<Place> places;

    private List<Booking> bookings;

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
