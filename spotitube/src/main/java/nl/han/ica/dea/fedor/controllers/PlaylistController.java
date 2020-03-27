package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;
import nl.han.ica.dea.fedor.dto.TrackDTO;
import nl.han.ica.dea.fedor.dto.TracksDTO;
import nl.han.ica.dea.fedor.services.PlaylistService;
import nl.han.ica.dea.fedor.services.TrackService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
public class PlaylistController {
    private PlaylistService playlistService;
    private TrackService trackService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPlaylists(@QueryParam("token") String token) {

        PlaylistsDTO all = playlistService.serviceAllPlaylists();

        return Response.ok(all).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlaylist(@PathParam("id") int id) {

        PlaylistDTO playlist = playlistService.serviceFindPlaylist(id);

        return Response.ok(playlist).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response editPlaylist(PlaylistDTO playlistDTO, @PathParam("id") int id) {

        playlistService.serviceEditPlaylist(playlistDTO, id);
        PlaylistsDTO all = playlistService.serviceAllPlaylists();

        return Response.ok(all).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlaylist(@PathParam("id") int id) {

        playlistService.serviceDeletePlaylist(id);
        PlaylistsDTO all = playlistService.serviceAllPlaylists();

        return Response.ok(all).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(PlaylistDTO playlistDTO) {

        playlistService.serviceAddPlaylist(playlistDTO);
        PlaylistsDTO all = playlistService.serviceAllPlaylists();

        return Response.ok(all).build();
    }

    @GET
    @Path("/{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allTracksFromPlaylist(@PathParam("id") int id) {

        TracksDTO all = trackService.serviceAllTracksFromPlaylist(id);

        return Response.ok(all).build();
    }

    @DELETE
    @Path("{id}/tracks/{track_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTrackFromPlaylist(@PathParam("id") int id, @PathParam("track_id") int track_id) {

        trackService.serviceDeleteTrackFromPlaylist(id, track_id);
        TracksDTO all = trackService.serviceAllTracksFromPlaylist(id);

        return Response.ok(all).build();
    }

    @POST
    @Path("{id}/tracks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrack(TrackDTO trackDTO, @PathParam("id") int id) {

        trackService.serviceAddTrackToPlaylist(id, trackDTO);
        TracksDTO all = trackService.serviceAllTracksFromPlaylist(id);

        return Response.ok(all).build();
    }

    @Inject
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Inject
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }
}
