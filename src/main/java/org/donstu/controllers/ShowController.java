package org.donstu.controllers;

import org.donstu.domain.Show;

import javax.ws.rs.Consumes;
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


@Path("/show")
public class ShowController {
    private static List<Show> shows = new ArrayList<>();
    static {
        shows.add(new Show("Dune: part two", new Date(), 235, "Red"));
        shows.add(new Show("Jumbo", new Date(), 115, "Red"));
        shows.add(new Show("The Good, The Bad, The Ugly", new Date(), 145, "Blue"));
        shows.add(new Show("Drive", new Date(), 120, "Green"));
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response defaultPath() {
        return getShows();
    }

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getShows() {
        GenericEntity<List<Show>> genericEntity = new GenericEntity<List<Show>>(shows) {};
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getShow(@PathParam("id") String id) {
        int num = Integer.parseInt(id);
        return Response.ok(shows.get(num)).build();


    }
}
