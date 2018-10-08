package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.datasources.SQLDatabaseConnection;

import nl.han.ica.dea.fedor.dto.PlaylistBuilderDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsResponseDTO;

import javax.inject.Inject;

public class PlaylistService {

    @Inject
    SQLDatabaseConnection connection;

    public PlaylistsResponseDTO getAllPlaylists() {
        PlaylistBuilderDTO playlist1 = new PlaylistBuilderDTO();
        playlist1.setPlaylist(1, "Death Metal", true, new int[0]);

        PlaylistBuilderDTO playlist2 = new PlaylistBuilderDTO();
        playlist2.setPlaylist(1, "Pop", false, new int[0]);

        PlaylistsResponseDTO playlistsResponseDTO = new PlaylistsResponseDTO();

        playlistsResponseDTO.addPlaylist(playlist1);
        playlistsResponseDTO.addPlaylist(playlist2);
        playlistsResponseDTO.setLength(123445);

        return playlistsResponseDTO;
    }

//    public PlaylistBuilderDTO findPlaylist(int id) {
//        for (PlaylistBuilderDTO singleList : playlistsResponseDTO.getPlaylists()) {
//            if (singleList.getId() == id) {
//                return singleList;
//            }
//        }
//        return null;
//    }


}
