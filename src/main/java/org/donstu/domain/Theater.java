package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class Theater implements Serializable {
    private List<Show> shows;

    private List<Seat> seats;

    private List<Reservation> reservations;

    public List<Show> getMovies() {
        return shows;
    }

    public void setMovies(List<Show> shows) {
        this.shows = shows;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
