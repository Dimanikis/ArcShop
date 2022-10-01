package arc.ua.arcshop.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private final String name;
    private final String email;
    private final String pictureUrl;

    private AccountDTO(String name, String email, String pictureUrl) {
        this.name = name;
        this.email = email;
        this.pictureUrl = pictureUrl;
    }

    public static AccountDTO of(String name, String email, String pictureUrl) {
        return new AccountDTO(name, email, pictureUrl);
    }

}
