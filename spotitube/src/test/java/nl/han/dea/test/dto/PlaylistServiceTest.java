package nl.han.dea.test.dto;

        import nl.han.ica.dea.fedor.datasources.PlaylistDAO;
        import nl.han.ica.dea.fedor.services.PlaylistService;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.Mock;
        import org.mockito.junit.MockitoJUnitRunner;

        import javax.inject.Inject;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistServiceTest {

    @Mock
    private PlaylistDAO playlistDAOMock;

    @Inject
    private PlaylistService sut;

    @Test
    public void
}
