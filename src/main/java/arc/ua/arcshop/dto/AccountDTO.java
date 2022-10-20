package arc.ua.arcshop.dto;

import arc.ua.arcshop.model.AccountRole;
import lombok.Data;

@Data
public class AccountDTO {

    private final String login;
    private final String password;
    private final AccountRole role;
    private final String name;
    private final String email;
    private final String pictureUrl;

    public AccountDTO(String login, String password, AccountRole role, String name, String email, String pictureUrl) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.pictureUrl = pictureUrl;
    }

    public static AccountDTO of(String login, String password, AccountRole role, String name, String email, String pictureUrl) {
        return new AccountDTO(login, password, role, name, email, pictureUrl);
    }

}
