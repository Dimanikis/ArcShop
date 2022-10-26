package arc.ua.arcshop.dto;

import arc.ua.arcshop.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private final String login;
    private final String password;
    private final String name;
    private final String email;
    private final String pictureUrl;
    private final Role role;

    public static UserDTO of(String login, String password, String name, String email, String pictureUrl, Role role) {
        return new UserDTO(login, password, name, email, pictureUrl, role);
    }

}
