package nl.han.dea.test.dto;

import nl.han.ica.dea.fedor.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class UserServiceTest {

    @Test
    public void testIsValidLogin(){
        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.isValidLogin("Test", "password")).thenReturn(true);
        Assert.assertEquals(true, userService.isValidLogin("Test", "password"));
    }

    @Test
    public void testIsNotValidLogin(){
        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.isValidLogin("Test", "password")).thenReturn(true);
        Assert.assertNotEquals(true, userService.isValidLogin("Test2", "password2"));
    }}

