package nl.han.dea.test.dto;

import nl.han.ica.dea.fedor.datasources.UserDAO;
import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDAO userDAOMock;

    @InjectMocks
    private UserService sut; // system-under-test


    @Test
    public void testIsValidLogin() {
        //Arrange
        UserDTO userDB = new UserDTO();
        userDB.setPassword("passDB");
        userDB.setUser("userDB");

        //Act
        when(userDAOMock.getUserDTO("userDB")).thenReturn(userDB);

        //Assert
        assertTrue(sut.isValidLogin("userDB", "passDB"));
    }

    @Test
    public void testIsNotValidPassword() {
        //Arrange
        UserDTO userDB = new UserDTO();
        userDB.setPassword("passDB");
        userDB.setUser("userDB");

        //Act
        when(userDAOMock.getUserDTO("userDB")).thenReturn(userDB);

        //Assert
        assertFalse(sut.isValidLogin("userDB", "false-password"));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testIsNotValidUser() {
        //Arrange
        UserDTO userDB = new UserDTO();
        userDB.setPassword("passDB");
        userDB.setUser("userDB");

        //Act
        when(userDAOMock.getUserDTO("userDB")).thenReturn(userDB);

        //Assert
        assertFalse(sut.isValidLogin("invalid-user", "passDB"));
    }
}