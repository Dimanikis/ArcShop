package arc.ua.arcshop.controllers;

import arc.ua.arcshop.dto.UserDTO;
import arc.ua.arcshop.model.JwtRequest;
import arc.ua.arcshop.model.JwtResponse;
import arc.ua.arcshop.model.RefreshJwtRequest;
import arc.ua.arcshop.model.Role;
import arc.ua.arcshop.services.AuthService;
import arc.ua.arcshop.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final AuthService authService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, AuthService authService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO){
        String passHash = passwordEncoder.encode(userDTO.getPassword());

        if ( ! userService.addUser(UserDTO.of(userDTO.getLogin(), passHash, null, null, null, Role.USER))) {
            return new ResponseEntity<>("""
                            {"status": "login already exist"}""",HttpStatus.OK);
        }

        return new ResponseEntity<>("""
                            {"status": "created"}""",HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}
