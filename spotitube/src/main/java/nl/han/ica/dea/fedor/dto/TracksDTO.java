package nl.han.ica.dea.fedor.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Tracks dto.
 */
public class TracksDTO {

    private List<TrackDTO> tracks = new ArrayList<>();

    /**
     * Sets tracks.
     *
     * @param tracks the tracks
     */
    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    /**
     * Add track.
     *
     * @param trackDTO the track dto
     */
    public void addTrack(TrackDTO trackDTO) {
        tracks.add(trackDTO);
    }

    /**
     * Gets tracks.
     *
     * @return the tracks
     */
    public List<TrackDTO> getTracks() {
        return tracks;
    }
}