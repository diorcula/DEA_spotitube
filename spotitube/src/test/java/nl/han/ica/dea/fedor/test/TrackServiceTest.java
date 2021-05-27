package nl.han.ica.dea.fedor.test;

import nl.han.ica.dea.fedor.dao.PlaylistDAO;
import nl.han.ica.dea.fedor.dao.TrackDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;
import nl.han.ica.dea.fedor.dto.TrackDTO;
import nl.han.ica.dea.fedor.dto.TracksDTO;
import nl.han.ica.dea.fedor.services.PlaylistService;
import nl.han.ica.dea.fedor.services.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrackServiceTest {

    @Mock
    private TrackDAO trackDAOMock;

    @InjectMocks
    private TrackService sut; // system-under-test

    private PlaylistDTO playlistDB;
    private PlaylistDTO playlistDB2;
    private TrackDTO trackDTO;
    private TrackDTO trackDTO2;

    private TracksDTO tracksDTO;


    @Before
    public void setUp() {
        playlistDB = new PlaylistDTO();
        playlistDB.setId(1);
        playlistDB.setName("sut-name");
        playlistDB.setOwner(true);
        playlistDB.setTracks(null);
        playlistDB.setDuration(5);

        playlistDB2 = new PlaylistDTO();
        playlistDB2.setId(2);
        playlistDB2.setName("sut-name22222");
        playlistDB2.setOwner(false);
        playlistDB2.setTracks(null);
        playlistDB2.setDuration(5);

        trackDTO = new TrackDTO();
        trackDTO.setId(1);
        trackDTO.setTitle("title");
        trackDTO.setPerformer("performer");
        trackDTO.setDuration(340);
        trackDTO.setAlbum("album");
        trackDTO.setPlaycount(2);
        trackDTO.setPublication_date("publication_date");
        trackDTO.setDescription("description");
        trackDTO.setOffline_available(true);

        trackDTO2 = new TrackDTO();
        trackDTO2.setId(2);
        trackDTO2.setTitle("2title");
        trackDTO2.setPerformer("2performer");
        trackDTO2.setDuration(342);
        trackDTO2.setAlbum("2album");
        trackDTO2.setPlaycount(4);
        trackDTO2.setPublication_date("publication_date2");
        trackDTO2.setDescription("description2");
        trackDTO2.setOffline_available(false);

    }

    @Test
    public void TestServiceAllTracksFromPlaylist(){
        // Arrange
        List<TrackDTO> trackDTOList = new ArrayList<>();
        trackDTOList.add(trackDTO);
        trackDTOList.add(trackDTO2);
        playlistDB.setTracks(trackDTOList);

        TracksDTO expected = new TracksDTO();
        expected.addTrack(trackDTO);
        expected.addTrack(trackDTO2);

        when(trackDAOMock.findTracksFromPlaylist(1)).thenReturn(trackDTOList);

        // Act
        TracksDTO result = sut.serviceAllTracksFromPlaylist(1);

        // Assert
        assertEquals(expected.getTracks(),result.getTracks());
    }

    @Test
    public void TestServiceDeleteTrackFromPlaylist() {
        // Arrange
        tracksDTO = new TracksDTO();
        tracksDTO.addTrack(trackDTO);
        List<TrackDTO> trackDTOList = new ArrayList<>();
        trackDTOList.add(trackDTO);
        playlistDB.setTracks(trackDTOList);

        List<TrackDTO> expected = new ArrayList<>();

        // Act
        sut.serviceDeleteTrackFromPlaylist(1, 1);

        // Assert
        assertEquals(expected, sut.serviceAllTracksFromPlaylist(1).getTracks());
    }

    @Test
    public void TestServiceAllTracks(){
        // Arrange
        List<TrackDTO> trackDTOList = new ArrayList<>();
        trackDTOList.add(trackDTO);
        trackDTOList.add(trackDTO2);
        playlistDB.setTracks(trackDTOList);

        TracksDTO expected = new TracksDTO();
        expected.addTrack(trackDTO);
        expected.addTrack(trackDTO2);

        when(trackDAOMock.findAll(1)).thenReturn(trackDTOList);

        // Act
        TracksDTO result = sut.serviceAllTracks(1);

        // Assert
        assertEquals(expected.getTracks(),result.getTracks());
    }
}
