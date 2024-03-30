package org.donstu.controllers;

import org.donstu.domain.Show;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/movie")
public class MovieController {
    private static List<Show> shows = new ArrayList<>();

    static {
        shows.add(new Show("Goodfellas", new Date(), 225, "First"));
        shows.add(new Show("The Shawshank Redemption", new Date(), 222, "Second"));
        shows.add(new Show("12 Angry Men", new Date(), 136, "Second"));
        shows.add(new Show("It's a Wonderful Life", new Date(), 210, "First"));
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response defaultPath() {
        return getMovies();
    }

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovies() {
        GenericEntity<List<Show>> genericEntity = new GenericEntity<List<Show>>(shows) {
        };
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovie(@PathParam("id") String id) {
        int num = Integer.parseInt(id);
        if (shows.size() <= num) {
            return Response.ok().build();
        } else {
            return Response.ok(shows.get(num)).build();
        }
    }
}
