package arc.ua.arcshop.model;

import arc.ua.arcshop.dto.AccountDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String login;

    private String password;
    private String name;
    private String email;
    private String pictureUrl;

    private Account(String login, String password, String name, String email, String pictureUrl) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.pictureUrl = pictureUrl;
    }

    public static Account of(String login, String password, String name, String email, String pictureUrl) {
        return new Account(login, password, name, email, pictureUrl);
    }

    public AccountDTO toDTO() {
        return AccountDTO.of(login, password, name, email, pictureUrl);
    }

    public static Account fromDTO(AccountDTO accountDTO) {
        return Account.of(accountDTO.getLogin(), accountDTO.getPassword(), accountDTO.getName(), accountDTO.getEmail(), accountDTO.getPictureUrl());
    }

}
