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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistServiceTest {

    @Mock
    private PlaylistDAO playlistDAOMock;

    @InjectMocks
    private PlaylistService sut; // system-under-test

    @Before
    public void setUp(){
   //     playlistsDTO.setLength(finalSom);
        doNothing().when(playlistDAOMock);
    }

    @Test
    public void TESTserviceAllPlaylists() {
        //Arrange
        PlaylistDTO playlistDB = new PlaylistDTO();
        playlistDB.setId(1);
        playlistDB.setName("sut-name");
        playlistDB.setOwner(true);
        playlistDB.setTracks(null);
        playlistDB.setDuration(3141);

        PlaylistDTO playlistDB2 = new PlaylistDTO();
        playlistDB2.setId(2);
        playlistDB2.setName("sut-name22222");
        playlistDB2.setOwner(false);
        playlistDB2.setTracks(null);
        playlistDB2.setDuration(666);

        PlaylistsDTO collectionPlaylists = new PlaylistsDTO();
        collectionPlaylists.addPlaylist(playlistDB);
        collectionPlaylists.addPlaylist(playlistDB2);

        //TODO
        System.out.println(collectionPlaylists.getPlaylists());
        System.out.println(sut.serviceAllPlaylists());

        //Act
        when(playlistDAOMock.findAll()).thenReturn(collectionPlaylists.getPlaylists());

        //Assert
        assertEquals(collectionPlaylists.getPlaylists(), sut.serviceAllPlaylists());
    }
}
