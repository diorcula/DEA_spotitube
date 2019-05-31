package nl.han.dea.test.dto;

import nl.han.ica.dea.fedor.dto.LoginResponseDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class LoginRequestDtoTest {

    @Test
    public void testEqualsIsTrueForEqualObject() {
        LoginResponseDTO request1 = new LoginResponseDTO("test", "test2");
        LoginResponseDTO request2 = new LoginResponseDTO("test", "test2");

        // Assert.
        assertEquals(request1.token, request2.token);
        assertEquals(request1.user, request2.user);
    }

    @Test
    public void testEqualsIsFalseForUnequalObject() {
    LoginResponseDTO request1 = new LoginResponseDTO("test", "test2");
    LoginResponseDTO request2 = new LoginResponseDTO("test2", "test");

    // Assert.
    assertNotEquals(request1.token, request2.token);
    assertNotEquals(request1.user, request2.user);    }
}