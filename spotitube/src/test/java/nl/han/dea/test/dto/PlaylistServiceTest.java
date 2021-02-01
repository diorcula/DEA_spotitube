package nl.han.dea.test.dto;

import nl.han.ica.dea.fedor.dao.PlaylistDAO;
import nl.han.ica.dea.fedor.dto.PlaylistDTO;
import nl.han.ica.dea.fedor.dto.PlaylistsDTO;
import nl.han.ica.dea.fedor.services.PlaylistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
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
    public void TESTserviceAllPlaylists() {
        //Arrange
        final int EXPECTED_LENGTH = 10;

        collectionPlaylists = new PlaylistsDTO();
        collectionPlaylists.addPlaylist(playlistDB);
        collectionPlaylists.addPlaylist(playlistDB2);

        when(playlistDAOMock.findAll()).thenReturn(collectionPlaylists.getPlaylists());

        //Act
        int result = sut.serviceAllPlaylists().getLength();

        //Assert
        assertEquals(EXPECTED_LENGTH, result);
    }
}
