package nl.han.ica.dea.fedor.dto;

public class LoginResponseDTO {

    public String token;
    public String user;

    public LoginResponseDTO(String token, String user){
        this.token = token;
        this.user = user;
    }
}