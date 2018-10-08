package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.services.PlaylistService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
public class PlaylistController {

    @Inject
    private PlaylistService playlistService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response Playlists() {
        return Response.ok(playlistService.getAllPlaylists()).build();
    }
}
