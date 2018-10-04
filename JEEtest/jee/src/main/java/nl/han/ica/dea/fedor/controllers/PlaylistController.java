package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.dto.PlaylistBuilderDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsResponseDTO;
import nl.han.ica.dea.fedor.services.PlaylistService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
public class PlaylistController {

    private PlaylistService playlistService = new PlaylistService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response Playlists() {
        return Response.ok(playlistService.getAllPlaylists()).build();
    }
}
