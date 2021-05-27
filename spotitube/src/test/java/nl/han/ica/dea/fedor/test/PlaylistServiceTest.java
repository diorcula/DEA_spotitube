package nl.han.ica.dea.fedor.test;

import nl.han.ica.dea.fedor.dao.PlaylistDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;
import nl.han.ica.dea.fedor.dto.TrackDTO;
import nl.han.ica.dea.fedor.dto.TracksDTO;
import nl.han.ica.dea.fedor.services.PlaylistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistServiceTest {

    @Mock
    private PlaylistDAO playlistDAOMock;

    @InjectMocks
    private PlaylistService sut; // system-under-test

    private PlaylistDTO playlistDB;
    private PlaylistDTO playlistDB2;
    private PlaylistsDTO collectionPlaylists;

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
    }

    @Test
    public void TestServiceFindPlaylist() {
        // Arrange
        when(playlistDAOMock.findOne(1)).thenReturn(playlistDB);

        // Act
        PlaylistDTO result = sut.serviceFindPlaylist(1);

        // Assert
        assertEquals(playlistDB, result);
    }

    @Test
    public void TestServiceEditPlaylist() {
        // Arrange
        PlaylistDTO newPlaylist = new PlaylistDTO();
        newPlaylist.setName("new-name");
        playlistDB.setName("new-name");

        // Act
        sut.serviceEditPlaylist(playlistDB, 1);

        // Assert
        assertEquals(newPlaylist.getName(), playlistDB.getName());
    }

    @Test
    public void TestServiceDeletePlaylist() {
        // Arrange
        collectionPlaylists = new PlaylistsDTO();
        collectionPlaylists.addPlaylist(playlistDB);

        // Act
        sut.serviceDeletePlaylist(1);

        // Assert
        assertEquals(null, sut.serviceFindPlaylist(1));
    }

    @Test
    public void TestCalculateDuration() {
        // Arrange
        List<PlaylistDTO> returnlist = new ArrayList<>();
        playlistDB.setDuration(15);
        returnlist.add(playlistDB);

        // Act
        int result = sut.calculateDuration(returnlist);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void TestSetDuration() {
        // Arrange
        List<PlaylistDTO> returnList = new ArrayList<>();
        PlaylistsDTO playlistsDTO = new PlaylistsDTO();

        playlistDB.setDuration(300);
        returnList.add(playlistDB);

        // Act
        sut.setDuration(returnList, playlistsDTO);
        int result = playlistsDTO.getLength();

        // Assert
        assertEquals(300, result);
    }

    @Test
    public void TestserviceAllPlaylists() {
        // Arrange
        List<PlaylistDTO> playlistDTOList = new ArrayList<>();
        playlistDTOList.add(playlistDB);
        playlistDTOList.add(playlistDB2);

        PlaylistsDTO expected = new PlaylistsDTO();
        expected.addPlaylist(playlistDB);
        expected.addPlaylist(playlistDB2);

        when(playlistDAOMock.findAll()).thenReturn(playlistDTOList);

        // Act
        PlaylistsDTO result = sut.serviceAllPlaylists();

        // Assert
        assertEquals(expected.getPlaylists(), result.getPlaylists());
    }

}
