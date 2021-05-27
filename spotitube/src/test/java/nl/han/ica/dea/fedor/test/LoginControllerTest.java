package nl.han.ica.dea.fedor.test;

import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.xml.registry.infomodel.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginControllerTest {
        @Mock
        private UserService userServiceMock;

        @Before
        public void setUp() throws Exception {
            loginEndpoint = new LoginEndpoint();
            MockitoAnnotations.initMocks(this);
        }

        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void testLogin() t {
            UserDTO userDTO = mock(UserDTO.class);
            when(userDTO.user).thenReturn("johndoe");
            when(userDTO.password).thenReturn("hunter2");
            when(userDTO.getToken()).thenReturn("1234");


            Response response = userServiceMock.
            assertEquals(200, response.getStatus());
        }
        
}
