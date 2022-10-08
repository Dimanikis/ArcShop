package arc.ua.arcshop.controllers;

import arc.ua.arcshop.dto.AccountDTO;
import arc.ua.arcshop.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/acc")
public class AccountController {

    private final AccountService accountService;

    private final PasswordEncoder passwordEncoder;

    public AccountController(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody AccountDTO accountDTO){
        String passHash = passwordEncoder.encode(accountDTO.getPassword());

        if ( ! accountService.addAccount(AccountDTO.of(accountDTO.getLogin(), passHash, null, null, null))) {
            return new ResponseEntity<>("login already exist",HttpStatus.OK);

        }

        return new ResponseEntity<>("created",HttpStatus.OK);

    }

    @PostMapping(path = "login")
    public @ResponseBody AccountDTO getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;
        return Objects.nonNull(user) ? accountService.getAccount(user.getUsername()) : null;
    }

    @GetMapping("logviagoogle")
    public AccountDTO logViaGoogle(OAuth2AuthenticationToken auth){
        Map<String, Object> attrs = auth.getPrincipal().getAttributes();

        String login = (String) attrs.get("login");
        String password = (String) attrs.get("password");
        String name = (String) attrs.get("name");
        String email = (String) attrs.get("email");
        String pictureUrl = (String) attrs.get("picture");

        return AccountDTO.of(login, password, name, email, pictureUrl);
    }


}
