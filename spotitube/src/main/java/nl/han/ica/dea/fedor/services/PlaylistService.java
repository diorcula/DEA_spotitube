package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.datasources.PlaylistDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;

import java.util.List;

public class PlaylistService {

    public PlaylistDAO playlistDAO;

    public PlaylistsDTO getAllPlaylists() {

        List<PlaylistDTO> returnList = playlistDAO.findAll();
        PlaylistsDTO playlistsDTO = new PlaylistsDTO();

//        int som=0;
//        for(PlaylistDTO dto:returnList){ som += dto.getDuration(); }
//        int finalSom=som;
//        returnList.forEach(playlistDTO->playlistsDTO.setLength(finalSom));

        returnList.forEach(playlistDTO -> playlistsDTO.addPlaylist(playlistDTO));

        return playlistsDTO;
    }
}
