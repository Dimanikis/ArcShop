package arc.ua.arcshop.controllers;

import arc.ua.arcshop.dto.AccountDTO;
import arc.ua.arcshop.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@RequestMapping("/acc")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("login")
    public AccountDTO login(@RequestParam String login,
                            @RequestParam String password){

        AccountDTO accountDTO = accountService.getAccount(login);

        return accountDTO;
    }

    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestParam String login,
                                         @RequestParam String password){


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
