package nl.han.ica.dea.fedor.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Playlists dto.
 */
public class PlaylistsDTO {
    private int length;
    private List<PlaylistDTO> playlists = new ArrayList<>();

    /**
     * Add playlist.
     *
     * @param playlistDTO the playlist dto
     */
    public void addPlaylist(PlaylistDTO playlistDTO) {
        playlists.add(playlistDTO);
    }

    /**
     * Gets playlists.
     *
     * @return the playlists
     */
    public List<PlaylistDTO> getPlaylists() {
        return playlists;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets length.
     *
     * @param length the length
     */
    public void setLength(int length) {
        this.length = length;
    }
}