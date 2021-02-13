package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.dao.PlaylistDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;

import javax.inject.Inject;
import java.util.List;

public class PlaylistService {
    @Inject
    PlaylistDAO playlistDAO;

    private final PlaylistsDTO playlistsDTO;

    @Inject
    PlaylistDTO playlistDTO;

    public PlaylistService() {
        this.playlistsDTO = new PlaylistsDTO();
    }

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
        playlistDAO.editPlaylist(playlistDTO, id);
    }

    public void serviceDeletePlaylist(int id) {
        playlistDAO.deletePlaylist(id);
    }

    public void serviceAddPlaylist(PlaylistDTO playlistDTO) {
        playlistDAO.addPlaylist(playlistDTO);
    }

    public void setDuration(List<PlaylistDTO> returnList) {
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

    public void setLists(List<PlaylistDTO> returnList) {
        returnList.forEach(playlistsDTO::addPlaylist);
    }
}