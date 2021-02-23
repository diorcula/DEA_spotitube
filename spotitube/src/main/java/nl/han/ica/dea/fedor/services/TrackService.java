package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.dao.TrackDAO;
import nl.han.ica.dea.fedor.dto.TrackDTO;
import nl.han.ica.dea.fedor.dto.TracksDTO;

import javax.inject.Inject;
import java.util.List;

public class TrackService {
    @Inject
    TrackDAO trackDAO;

    public TracksDTO serviceAllTracksFromPlaylist(int id) {
        TracksDTO tracksDTO = new TracksDTO();
        List<TrackDTO> returnList = trackDAO.findTracksFromPlaylist(id);
        setTracks(returnList, tracksDTO);

        return tracksDTO;
    }

    public void serviceDeleteTrackFromPlaylist(int id, int track_id) {
        trackDAO.deleteTrack(id, track_id);
    }

    public void serviceAddTrackToPlaylist(int id, TrackDTO trackDTO) {
        trackDAO.addTrack(id, trackDTO);
    }

    private void setTracks(List<TrackDTO> returnList, TracksDTO tracksDTO) {
        returnList.forEach(tracksDTO::addTrack);
    }

    public TracksDTO serviceAllTracks(int forPlaylist) {
        TracksDTO tracksDTO = new TracksDTO();
        List<TrackDTO> returnList = trackDAO.findAll(forPlaylist);
        setTracks(returnList, tracksDTO);

        return tracksDTO;
    }
}
