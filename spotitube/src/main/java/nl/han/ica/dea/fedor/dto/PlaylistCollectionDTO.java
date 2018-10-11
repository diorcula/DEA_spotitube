package nl.han.ica.dea.fedor.dto;

import java.util.ArrayList;
import java.util.List;

public class PlaylistCollectionDTO {
    private int length;

    private List<PlaylistBuilderDTO> playlists = new ArrayList<>();

    public void addPlaylist(PlaylistBuilderDTO koek) {
        playlists.add(koek);
    }

    public List<PlaylistBuilderDTO> getPlaylists() {
        return playlists;
    }

    public int getLength() {

        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
