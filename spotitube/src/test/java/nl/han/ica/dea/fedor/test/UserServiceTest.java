package nl.han.ica.dea.fedor.test;

import nl.han.ica.dea.fedor.dao.UserDAO;
import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.exceptionMapper.exceptions.UnauthorizedLoginException;
import nl.han.ica.dea.fedor.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
    public void setUp() {
        userDB = new UserDTO();
        userDB.setPassword(PASSWORD);
        userDB.setUser(USER);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    // valid user + valid password
    public void testIsValidLogin() {
        //Arrange
        when(userDAOMock.userExists(USER)).thenReturn(true);
        when(userDAOMock.getUserDTO(USER)).thenReturn(userDB);

        //Act
        boolean result = sut.isValidLogin(USER, PASSWORD);

        //Assert
        assertTrue(result);
    }

    @Test
    // valid user + invalid password
    public void testIsNotValidPassword() {
        //Arrange
        when(userDAOMock.userExists(USER)).thenReturn(true);
        when(userDAOMock.getUserDTO(USER)).thenReturn(userDB);

        //Act
        boolean result = sut.isValidLogin(USER, "FALSE-PASSWORD");

        //Assert
        assertFalse(result);
    }

    @Test
    // invalid user, tests if UnauthorizedLoginException is thrown
    public void testIsNotValidUSerException() {
        when(userDAOMock.userExists(USER)).thenReturn(false);

        exception.expect(UnauthorizedLoginException.class);
        exception.expectMessage("invalid login");

        //Act
        sut.isValidLogin(USER, PASSWORD);
    }

}