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

@Path("/show")
public class ShowController {
    private static List<Show> shows = new ArrayList<>();

    static {
        shows.add(new Show("Two people","Two people in the elevator, not counting tequila", new Date(), 130, "First"));
        shows.add(new Show("Crazy Day","Crazy Day, or the Marriage of Figaro", new Date(), 145, "Second"));
        shows.add(new Show("DON","Quiet Don", new Date(), 180, "Second"));
        shows.add(new Show("Wonder","It's a Wonderful Life", new Date(), 210, "First"));
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
        GenericEntity<List<Show>> genericEntity = new GenericEntity<List<Show>>(shows) {
        };
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getShows(@PathParam("id") String id) {
        int num = Integer.parseInt(id);
        if (shows.size() <= num) {
            return Response.ok().build();
        } else {
            return Response.ok(shows.get(num)).build();
        }
    }
}
