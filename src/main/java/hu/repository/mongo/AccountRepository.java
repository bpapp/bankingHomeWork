package hu.repository.mongo;

import hu.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> getAllAccounts();
    Account getAccountById(long accountId);
    boolean deleteAccount(long accountId);
}
