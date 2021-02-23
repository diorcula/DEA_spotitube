package nl.han.ica.dea.fedor.dto;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsDTO {
    private int length;
    private List<PlaylistDTO> playlists = new ArrayList<>();

    public void addPlaylist(PlaylistDTO playlistDTO) {
        playlists.add(playlistDTO);
    }

    public List<PlaylistDTO> getPlaylists() {
        return playlists;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}