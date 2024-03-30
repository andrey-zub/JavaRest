package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class Reservation implements Serializable {
    private Show show;

    private List<Seat> seats;

    public Show getMovie() {
        return show;
    }

    public void setMovie(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
