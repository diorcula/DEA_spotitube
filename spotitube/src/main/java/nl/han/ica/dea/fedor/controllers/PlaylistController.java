package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.datasources.PlaylistDAO;
import nl.han.ica.dea.fedor.datasources.TrackDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;
import nl.han.ica.dea.fedor.dto.TrackDTO;
import nl.han.ica.dea.fedor.dto.TracksDTO;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/playlists")
public class PlaylistController {

    @Inject
    private PlaylistDAO playlistDAO;
    private TrackDAO trackDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPlaylists() {

        List<PlaylistDTO> all = playlistDAO.findAll();

        PlaylistsDTO playlistsDTO = new PlaylistsDTO();

        all.forEach(playlistDTO -> playlistsDTO.addPlaylist(playlistDTO));

        playlistsDTO.setLength(12345);

        return Response.ok(playlistsDTO).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlaylist(@PathParam("id") int id) {
        return Response.ok(playlistDAO.findOne(id)).build();
    }

    @GET
    @Path("{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allTracks(@PathParam("id") int id) {
        trackDAO = new TrackDAO();
        TracksDTO tracksDTO = new TracksDTO();

        List<TrackDTO> tracks = trackDAO.findTracksFromPlaylist(id);

        tracks.forEach(trackDTO -> tracksDTO.addTrack(trackDTO));

        return Response.ok(tracksDTO).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response editPlaylist(PlaylistDTO playlistDTO, @PathParam("id") int id) {

        return Response.ok(playlistDAO.editPlaylist(playlistDTO, id)).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePlaylist(@PathParam("id") int id) {
        playlistDAO.deletePlaylist(id);
        return Response.ok(playlistDAO.findAll()).build();
    }

    @POST
    //@Produces (MediaType.APPLICATION_JSON);
    @Path("{name}")
    public Response addPlaylist(@PathParam("name") String name){
        playlistDAO.addPlaylist(name);
        return Response.ok(playlistDAO.findAll()).build();
    }
}
