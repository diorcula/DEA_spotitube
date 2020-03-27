package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.datasources.PlaylistDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;

import java.util.List;

public class PlaylistService {

    public PlaylistDAO playlistDAO = new PlaylistDAO();
    public PlaylistsDTO playlistsDTO = new PlaylistsDTO();
    public PlaylistDTO playlistDTO = new PlaylistDTO();


    public PlaylistsDTO serviceAllPlaylists() {
        List<PlaylistDTO> returnList = playlistDAO.findAll();

        setDuration(returnList);
        setLists(returnList);

        return playlistsDTO;
    }

    public PlaylistDTO serviceFindPlaylist(int id) {
        playlistDTO = playlistDAO.findOne(id);
        return playlistDTO;
    }

    public void serviceEditPlaylist(PlaylistDTO playlistDTO, int id) {
        //TODO
        playlistDAO.editPlaylist(playlistDTO, id);
    }

    public void setDuration(List<PlaylistDTO> returnList) {
        int som = 0;

        for (PlaylistDTO dto : returnList) {
            som += dto.getDuration();
        }

        int finalSom = som;

        returnList.forEach(playlistDTO -> playlistsDTO.setLength(finalSom));
    }

    public void setLists(List<PlaylistDTO> returnList) {
        returnList.forEach(playlistDTO -> playlistsDTO.addPlaylist(playlistDTO));
    }
}