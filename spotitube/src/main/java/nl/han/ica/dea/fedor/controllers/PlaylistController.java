package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.datasources.PlaylistDAO;
import nl.han.ica.dea.fedor.datasources.TrackDAO;
import nl.han.ica.dea.fedor.dto.PlaylistBuilderDTO;

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
    public Response allPlaylists() {
        return Response.ok(playlistDAO.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlaylist(@PathParam("id") int id){
        return Response.ok(playlistDAO.findOne(id)).build();
    }

//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("{id}")
//    public Response editPlaylist(PlaylistBuilderDTO playlistBuilderDTO, @PathParam("id") int id) {
//        return Response.ok(playlistDAO.editPlaylist(playlistBuilderDTO, id)).build();
//    }

    @GET
    @Path("{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allTracks(@PathParam("id") int id) {
        TrackDAO trackDAO = new TrackDAO();
        return Response.ok(trackDAO.findTracksFromPlaylist(id)).build();
    }
}
