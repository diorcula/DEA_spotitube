package nl.han.dea.test.dto;

import nl.han.ica.dea.fedor.dao.UserDAO;
import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.services.UserService;
import org.junit.Before;
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

    private final String PASSWORD = "DATABASEPASSWORD";
    private final String USER = "DATABASEUSER";
    private UserDTO userDB;

    @Before
    public void setUp(){
        userDB = new UserDTO();
        userDB.setPassword(PASSWORD);
        userDB.setUser(USER);
    }

    @Test
    public void testIsValidLogin() {
        //Arrange
        when(userDAOMock.getUserDTO(USER)).thenReturn(userDB);

        //Act
        boolean result = sut.isValidLogin(USER, PASSWORD);

        //Assert
        assertTrue(result);
    }

    @Test
    public void testIsNotValidPassword() {
        //Arrange

        //Act
        when(userDAOMock.getUserDTO("userDB")).thenReturn(userDB);

        //Assert
        assertFalse(sut.isValidLogin("userDB", "false-password"));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testIsNotValidUser() {
        //Arrange

        //Act
       // when(userDAOMock.getUserDTO("userDB")).thenReturn(userDB);

        //Assert
        assertFalse(sut.isValidLogin("invalid-user", "passDB"));
    }

//    @Test(expected = java.lang.NullPointerException.class)
//    public void testNoPasswordApplied() {
//        //Arrange
//        UserDTO userDB = new UserDTO();
//        userDB.setPassword("userPassword");
//        userDB.setUser("userDB");
//
//        //Act
//        when(userDAOMock.getUserDTO("userDB")).thenReturn(userDB);
//
//        //Assert
//        assertFalse(sut.isValidLogin("userDB", null));
//    }
}