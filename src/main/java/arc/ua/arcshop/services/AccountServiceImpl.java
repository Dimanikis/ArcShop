package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.AccountDTO;
import arc.ua.arcshop.model.Account;
import arc.ua.arcshop.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional //////////
    @Override
    public boolean addAccount(AccountDTO accountDTO){
        if(accountRepository.existsByLogin(accountDTO.getLogin()))
            return false;

        Account account = Account.fromDTO(accountDTO);
        accountRepository.save(account);

        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public AccountDTO getAccount(String login){
        return accountRepository.findByLogin(login).toDTO();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }

        return new User(account.getLogin(), account.getPassword(), true, true, true, true, new HashSet<>());
    }
}
