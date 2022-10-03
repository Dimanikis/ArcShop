package arc.ua.arcshop.repository;

import arc.ua.arcshop.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByLogin(String login);

    Account findByLogin(String login);


}
