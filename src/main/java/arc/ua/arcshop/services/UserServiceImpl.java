package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.UserDTO;
import arc.ua.arcshop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional //////////
    @Override
    public boolean addUser(UserDTO userDTO){
        if(userRepository.existsByLogin(userDTO.getLogin()))
            return false;

        arc.ua.arcshop.model.User user =  arc.ua.arcshop.model.User.fromDTO(userDTO);
        userRepository.save(user);

        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDTO getUser(String login){
        return userRepository.findByLogin(login).toDTO();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        arc.ua.arcshop.model.User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }

        List<GrantedAuthority> roles = Arrays.asList(
                new SimpleGrantedAuthority(user.getRole().toString())
        );

        return new User(user.getLogin(), user.getPassword(), roles);
    }
}
