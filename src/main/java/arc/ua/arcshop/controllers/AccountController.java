package arc.ua.arcshop.controllers;

import arc.ua.arcshop.dto.AccountDTO;
import arc.ua.arcshop.services.AccountService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/acc")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("logviagoogle")
    public AccountDTO logViaGoogle(OAuth2AuthenticationToken auth){
        Map<String, Object> attrs = auth.getPrincipal().getAttributes();

        String name = (String) attrs.get("name");
        String email = (String) attrs.get("email");
        String pictureUrl = (String) attrs.get("picture");

        return AccountDTO.of(name, email, pictureUrl);
    }


}
