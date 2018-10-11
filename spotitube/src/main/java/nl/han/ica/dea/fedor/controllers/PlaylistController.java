package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.datasources.PlaylistDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
public class PlaylistController {

    @Inject
    private PlaylistDAO playlistDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response Playlists() {
        return Response.ok(playlistDAO.findAll()).build();
    }

//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response EditPlaylist(PlaylistBuilderDTO playlistBuilderDTO, @PathParam("id") int id){
//        return Response.ok(playlistService.editPlaylist(id, playlistBuilderDTO)).build();
//    }
}
