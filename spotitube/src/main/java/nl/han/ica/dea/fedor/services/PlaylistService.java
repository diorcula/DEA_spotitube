package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.dao.PlaylistDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Playlist service.
 */
public class PlaylistService {
    /**
     * The Playlist dao.
     */
    @Inject
    PlaylistDAO playlistDAO;

    /**
     * Service all playlists playlists dto.
     *
     * @return the playlists dto
     */
    public PlaylistsDTO serviceAllPlaylists() {
        PlaylistsDTO playlistsDTO = new PlaylistsDTO();
        List<PlaylistDTO> returnList = playlistDAO.findAll();

        setDuration(returnList, playlistsDTO);
        setLists(returnList, playlistsDTO);

        return playlistsDTO;
    }

    /**
     * Service find playlist playlist dto.
     *
     * @param id the id
     * @return the playlist dto
     */
    public PlaylistDTO serviceFindPlaylist(int id) {
        return playlistDAO.findOne(id);
    }

    /**
     * Service edit playlist.
     *
     * @param playlistDTO the playlist dto
     * @param id          the id
     */
    public void serviceEditPlaylist(PlaylistDTO playlistDTO, int id) {
        playlistDAO.editPlaylist(playlistDTO, id);
    }

    /**
     * Service delete playlist.
     *
     * @param id the id
     */
    public void serviceDeletePlaylist(int id) {
        playlistDAO.deletePlaylist(id);
    }

    /**
     * Service add playlist.
     *
     * @param playlistDTO the playlist dto
     */
    public void serviceAddPlaylist(PlaylistDTO playlistDTO) {
        playlistDAO.addPlaylist(playlistDTO);
    }

    /**
     * Sets duration.
     *
     * @param returnList   the return list
     * @param playlistsDTO the playlists dto
     */
    public void setDuration(List<PlaylistDTO> returnList, PlaylistsDTO playlistsDTO) {
        int finalSom = calculateDuration(returnList);

        playlistsDTO.setLength(finalSom);
    }

    /**
     * Calculate duration int.
     *
     * @param returnList the return list
     * @return the int
     */
    public int calculateDuration(List<PlaylistDTO> returnList) {
        int som = 0;

        for (PlaylistDTO dto : returnList) {
            som += dto.getDuration();
        }

        return som;
    }

    /**
     * Sets lists.
     *
     * @param returnList   the return list
     * @param playlistsDTO the playlists dto
     */
    public void setLists(List<PlaylistDTO> returnList, PlaylistsDTO playlistsDTO) {
        returnList.forEach(playlistsDTO::addPlaylist);
    }
}