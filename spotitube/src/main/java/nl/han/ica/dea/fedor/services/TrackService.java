package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.datasources.TrackDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.TrackDTO;
import nl.han.ica.dea.fedor.dto.TracksDTO;

import javax.inject.Inject;
import java.util.List;

public class TrackService {
    @Inject
    TrackDAO trackDAO;
    @Inject
    TracksDTO tracksDTO;

    public TracksDTO serviceAllTracksFromPlaylist(int id) {
        List<TrackDTO> returnList = trackDAO.findTracksFromPlaylist(id);
        setTracks(returnList);

        return tracksDTO;
    }

    public void serviceDeleteTrackFromPlaylist(int id, int track_id) {
        trackDAO.deleteTrack(id, track_id);
    }

    public void serviceAddTrackToPlaylist(int id, TrackDTO trackDTO) {
        trackDAO.addTrack(id, trackDTO);
    }

    private void setTracks(List<TrackDTO> returnList) {
        returnList.forEach(trackDTO -> tracksDTO.addTrack(trackDTO));
    }


}
