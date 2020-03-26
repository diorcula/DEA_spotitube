//package nl.han.dea.test.dto;
//
//import nl.han.ica.dea.fedor.datasources.UserDAO;
//import nl.han.ica.dea.fedor.dto.UserDTO;
//import nl.han.ica.dea.fedor.services.UserService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserServiceTest {
//
//    @Mock
//    private UserDAO userDAOMock;
//
//    @InjectMocks
//    private UserService sut; // system-under-test
//
//
//    @Test
//    public void testIsValidLogin(){
//        UserDTO user = new UserDTO();
//        user.setPassword("pass");
//        user.setUser("user");
//        when(userDAOMock.getUserDTO("user")).thenReturn(user);
//
//        assertTrue(sut.isValidLogin("user", "pass"));
//        assertFalse(sut.isValidLogin("user", "wrong"));
//
//    }
//
//    @Test
//    public void testIsNotValidLogin(){
//        UserService userService = Mockito.mock(UserService.class);
//        when(userService.isValidLogin("Test", "password")).thenReturn(true);
//        Assert.assertNotEquals(true, userService.isValidLogin("Test2", "password2"));
//    }}
//
