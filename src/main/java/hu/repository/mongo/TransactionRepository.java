package hu.repository.mongo;

import hu.Account;
import hu.model.mongo.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transactions, String> {

    List<Transactions> getAllTransactions();
    List<Transactions> getTransactionsHistoryByAccountId(long accountId);
    List<Transactions> getTransactionHistoryWithAttributes(Date date, BigDecimal amount, BigDecimal balance);
}
