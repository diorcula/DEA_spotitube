package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.dao.TrackDAO;
import nl.han.ica.dea.fedor.dto.TrackDTO;
import nl.han.ica.dea.fedor.dto.TracksDTO;

import javax.inject.Inject;
import java.util.List;

/**
 * The type Track service.
 */
public class TrackService {
    /**
     * The Track dao.
     */
    @Inject
    TrackDAO trackDAO;

    /**
     * Service all tracks from playlist tracks dto.
     *
     * @param id the id
     * @return the tracks dto
     */
    public TracksDTO serviceAllTracksFromPlaylist(int id) {
        TracksDTO tracksDTO = new TracksDTO();
        List<TrackDTO> returnList = trackDAO.findTracksFromPlaylist(id);
        setTracks(returnList, tracksDTO);

        return tracksDTO;
    }

    /**
     * Service delete track from playlist.
     *
     * @param id       the id
     * @param track_id the track id
     */
    public void serviceDeleteTrackFromPlaylist(int id, int track_id) {
        trackDAO.deleteTrack(id, track_id);
    }

    /**
     * Service add track to playlist.
     *
     * @param id       the id
     * @param trackDTO the track dto
     */
    public void serviceAddTrackToPlaylist(int id, TrackDTO trackDTO) {
        trackDAO.addTrack(id, trackDTO);
    }

    private void setTracks(List<TrackDTO> returnList, TracksDTO tracksDTO) {
        returnList.forEach(tracksDTO::addTrack);
    }

    /**
     * Service all tracks tracks dto.
     *
     * @param forPlaylist the for playlist
     * @return the tracks dto
     */
    public TracksDTO serviceAllTracks(int forPlaylist) {
        TracksDTO tracksDTO = new TracksDTO();
        List<TrackDTO> returnList = trackDAO.findAll(forPlaylist);
        setTracks(returnList, tracksDTO);

        return tracksDTO;
    }
}
