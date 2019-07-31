package hu.service;

import hu.Account;
import hu.repository.mongo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository  accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    public Account getAccountById(long accountId) {
        return accountRepository.getAccountById(accountId);
    }


    public boolean deleteAccount(long accountId)  {
        Account delete = getAccountById(accountId);
        delete.setActive(false);
        return true;
    }
}
