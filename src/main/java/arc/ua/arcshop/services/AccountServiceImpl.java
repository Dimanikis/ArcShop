package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.AccountDTO;
import arc.ua.arcshop.model.Account;
import arc.ua.arcshop.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public void addAccount(AccountDTO accountDTO){
        if(accountRepository.existsByEmail(accountDTO.getEmail()))
            return;

        Account account = Account.fromDTO(accountDTO);

        accountRepository.save(account);
    }
}
