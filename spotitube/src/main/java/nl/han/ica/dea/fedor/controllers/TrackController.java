package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.dto.TracksDTO;
import nl.han.ica.dea.fedor.services.TrackService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The type Track controller.
 */
@Path("/tracks")
public class TrackController {
    private TrackService trackService;

    /**
     * All tracks response.
     *
     * @param forPlaylist the for playlist
     * @return the response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allTracks(@QueryParam("forPlaylist") int forPlaylist) {

        TracksDTO all = trackService.serviceAllTracks(forPlaylist);

        return Response.ok(all).build();
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
