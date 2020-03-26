package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.datasources.PlaylistDAO;
import nl.han.ica.dea.fedor.datasources.TrackDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;

import java.util.List;

public class PlaylistService {

    private PlaylistDAO playlistDAO;
    private TrackDAO trackDAO;

    public List<PlaylistDTO> getAllPlaylists(){
        List<PlaylistDTO> returnList = playlistDAO.findAll();

        PlaylistsDTO playlistsDTO = new PlaylistsDTO();
        returnList.forEach(playlistDTO -> playlistsDTO.addPlaylist(playlistDTO));

        int som = 0;
        for (PlaylistDTO dto : returnList) {
            som += dto.getDuration();
        }

        int finalSom = som;
        returnList.forEach(playlistDTO -> playlistsDTO.setLength(finalSom));
        System.out.println(returnList);
        return returnList;
    }
}
