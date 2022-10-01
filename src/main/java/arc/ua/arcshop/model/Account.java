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
    @Column(nullable = false)
    private String name;
    private String email;
    private String pictureUrl;

    private Account(String name, String email, String pictureUrl) {
        this.name = name;
        this.email = email;
        this.pictureUrl = pictureUrl;
    }

    public static Account of(String name, String email, String pictureUrl) {
        return new Account(name, email, pictureUrl);
    }

    public AccountDTO toDTO() {
        return AccountDTO.of(name, email, pictureUrl);
    }

    public static Account fromDTO(AccountDTO accountDTO) {
        return Account.of(accountDTO.getName(), accountDTO.getEmail(), accountDTO.getPictureUrl());
    }

}
