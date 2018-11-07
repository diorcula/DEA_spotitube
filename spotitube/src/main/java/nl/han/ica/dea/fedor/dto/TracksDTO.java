package nl.han.ica.dea.fedor.dto;

import java.util.ArrayList;
import java.util.List;

public class TracksDTO {

    private List<TrackDTO> tracks = new ArrayList<>();


    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(TrackDTO trackDTO) {
        tracks.add(trackDTO);
    }

    public List<TrackDTO> getTracks() {
        return tracks;
    }


}