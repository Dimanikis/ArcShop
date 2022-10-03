package arc.ua.arcshop.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private final String login;
    private final String password;
    private final String name;
    private final String email;
    private final String pictureUrl;

    private AccountDTO(String login, String password, String name, String email, String pictureUrl) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.pictureUrl = pictureUrl;
    }

    public static AccountDTO of(String login, String password, String name, String email, String pictureUrl) {
        return new AccountDTO(login, password, name, email, pictureUrl);
    }

}
