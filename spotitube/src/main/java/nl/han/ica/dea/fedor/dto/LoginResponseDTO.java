package nl.han.ica.dea.fedor.dto;

/**
 * The type Login response dto.
 */
public class LoginResponseDTO {

    /**
     * The Token.
     */
    public String token;
    /**
     * The User.
     */
    public String user;

    /**
     * Instantiates a new Login response dto.
     *
     * @param token the token
     * @param user  the user
     */
    public LoginResponseDTO(String token, String user) {
        this.token = token;
        this.user = user;
    }
}
