package nl.han.ica.dea.fedor.test;

import nl.han.ica.dea.fedor.controllers.LoginController;
import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.services.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LoginControllerTest {
    @Mock
    private UserDTO userDTO;
    public LoginController sut;

    @InjectMocks
    private UserService userServiceMock;

    @BeforeEach
    void setUp() {
        this.userServiceMock = Mockito.mock(UserService.class);
        sut.setUserService(userServiceMock);
    }

    @Test
    public void testLogin() {
        userDTO = new UserDTO();
        userDTO.setUser("user");
        userDTO.setPassword("password");

        when(userServiceMock.isValidLogin(userDTO.user, userDTO.password)).thenReturn(true);

        Response response = sut.Login(userDTO);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}
