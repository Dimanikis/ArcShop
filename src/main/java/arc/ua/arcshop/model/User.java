package arc.ua.arcshop.model;

import arc.ua.arcshop.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String login;
    private String password;
    private String name;
    private String email;
    private String pictureUrl;
    @Enumerated(EnumType.STRING)
    private Role role;

    private User(String login, String password,String name, String email, String pictureUrl, Role role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.role = role;
    }

    public static User of(String login, String password, String name, String email, String pictureUrl, Role role) {
        return new User(login, password, name, email, pictureUrl, role);
    }

    public UserDTO toDTO() {
        return UserDTO.of(login, password, name, email, pictureUrl, role);
    }

    public static User fromDTO(UserDTO userDTO) {
        return User.of(userDTO.getLogin(), userDTO.getPassword(),userDTO.getName(), userDTO.getEmail(), userDTO.getPictureUrl(), userDTO.getRole());
    }

}
