package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    boolean addAccount(AccountDTO accountDTO);

    AccountDTO getAccount(String login);


}
