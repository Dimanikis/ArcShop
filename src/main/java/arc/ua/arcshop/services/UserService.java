package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.UserDTO;

public interface UserService {

    boolean addUser(UserDTO userDTO);

    UserDTO getUser(String login);


}
