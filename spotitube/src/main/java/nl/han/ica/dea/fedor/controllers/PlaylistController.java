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

/**
 * The type Playlist controller.
 */
@Path("/playlists")
public class PlaylistController {
    private PlaylistService playlistService;
    private TrackService trackService;

    /**
     * All playlists response.
     *
     * @param token the token
     * @return the response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPlaylists(@QueryParam("token") String token) {

        PlaylistsDTO all = playlistService.serviceAllPlaylists();

        return Response.ok(all).build();
    }

    /**
     * Find playlist response.
     *
     * @param id the id
     * @return the response
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlaylist(@PathParam("id") int id) {

        PlaylistDTO playlist = playlistService.serviceFindPlaylist(id);

        return Response.ok(playlist).build();
    }

    /**
     * Edit playlist response.
     *
     * @param playlistDTO the playlist dto
     * @param id          the id
     * @return the response
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response editPlaylist(PlaylistDTO playlistDTO, @PathParam("id") int id) {

        playlistService.serviceEditPlaylist(playlistDTO, id);
        PlaylistsDTO all = playlistService.serviceAllPlaylists();

        return Response.ok(all).build();
    }

    /**
     * Delete playlist response.
     *
     * @param id the id
     * @return the response
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlaylist(@PathParam("id") int id) {

        playlistService.serviceDeletePlaylist(id);
        PlaylistsDTO all = playlistService.serviceAllPlaylists();

        return Response.ok(all).build();
    }

    /**
     * Add playlist response.
     *
     * @param playlistDTO the playlist dto
     * @return the response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(PlaylistDTO playlistDTO) {

        playlistService.serviceAddPlaylist(playlistDTO);
        PlaylistsDTO all = playlistService.serviceAllPlaylists();

        return Response.ok(all).build();
    }

    /**
     * All tracks from playlist response.
     *
     * @param id the id
     * @return the response
     */
    @GET
    @Path("/{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allTracksFromPlaylist(@PathParam("id") int id) {

        TracksDTO all = trackService.serviceAllTracksFromPlaylist(id);

        return Response.ok(all).build();
    }

    /**
     * Delete track from playlist response.
     *
     * @param id       the id
     * @param track_id the track id
     * @return the response
     */
    @DELETE
    @Path("{id}/tracks/{track_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTrackFromPlaylist(@PathParam("id") int id, @PathParam("track_id") int track_id) {

        trackService.serviceDeleteTrackFromPlaylist(id, track_id);
        TracksDTO all = trackService.serviceAllTracksFromPlaylist(id);

        return Response.ok(all).build();
    }

    /**
     * Add track response.
     *
     * @param trackDTO the track dto
     * @param id       the id
     * @return the response
     */
    @POST
    @Path("{id}/tracks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrack(TrackDTO trackDTO, @PathParam("id") int id) {

        trackService.serviceAddTrackToPlaylist(id, trackDTO);
        TracksDTO all = trackService.serviceAllTracksFromPlaylist(id);

        return Response.ok(all).build();
    }

    /**
     * Sets playlist service.
     *
     * @param playlistService the playlist service
     */
    @Inject
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    /**
     * Sets track service.
     *
     * @param trackService the track service
     */
    @Inject
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }
}
