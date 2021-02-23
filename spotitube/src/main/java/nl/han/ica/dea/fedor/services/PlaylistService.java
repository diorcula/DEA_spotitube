package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.dao.PlaylistDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

public class PlaylistService {
    @Inject
    PlaylistDAO playlistDAO;

    public PlaylistsDTO serviceAllPlaylists() {
        PlaylistsDTO playlistsDTO = new PlaylistsDTO();
        List<PlaylistDTO> returnList = playlistDAO.findAll();

        setDuration(returnList, playlistsDTO);
        setLists(returnList, playlistsDTO);

        return playlistsDTO;
    }

    public PlaylistDTO serviceFindPlaylist(int id) {
        return playlistDAO.findOne(id);
    }

    public void serviceEditPlaylist(PlaylistDTO playlistDTO, int id) {
        playlistDAO.editPlaylist(playlistDTO, id);
    }

    public void serviceDeletePlaylist(int id) {
        playlistDAO.deletePlaylist(id);
    }

    public void serviceAddPlaylist(PlaylistDTO playlistDTO) {
        playlistDAO.addPlaylist(playlistDTO);
    }

    public void setDuration(List<PlaylistDTO> returnList, PlaylistsDTO playlistsDTO) {
        int finalSom = calculateDuration(returnList);

        playlistsDTO.setLength(finalSom);
    }

    public int calculateDuration(List<PlaylistDTO> returnList) {
        int som = 0;

        for (PlaylistDTO dto : returnList) {
            som += dto.getDuration();
        }

        return som;
    }

    public void setLists(List<PlaylistDTO> returnList, PlaylistsDTO playlistsDTO) {
        returnList.forEach(playlistsDTO::addPlaylist);
    }
}