package nl.han.ica.dea.fedor.controllers;


import nl.han.ica.dea.fedor.datasources.TrackDAO;
import nl.han.ica.dea.fedor.dto.TrackDTO;
import nl.han.ica.dea.fedor.dto.TracksDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tracks")
public class TrackController {
    @Inject
    private TrackDAO trackDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allTracks(@QueryParam("forPlaylist") int forPlaylist, @QueryParam("token") String token) {

        List<TrackDTO> all = trackDAO.findAll();
        TracksDTO tracksDTO = new TracksDTO();
        all.forEach(trackDTO -> tracksDTO.addTrack(trackDTO));

        return Response.ok(tracksDTO).build();
    }
}
