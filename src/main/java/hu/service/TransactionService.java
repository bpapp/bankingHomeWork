package hu.service;

import hu.model.mongo.Transactions;
import hu.repository.mongo.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Object doTransactionHistoryPrinting(long accountId) {
        List<Transactions> list = transactionRepository.getTransactionsHistoryByAccountId(accountId);
        list.forEach(System.out::println);
        return null;
    }

    public void getTransactionHistoryWithAttr(Date date, BigDecimal amount, BigDecimal balance) {
        List<Transactions> list = transactionRepository.getTransactionHistoryWithAttributes(date, amount, balance);
    }
}
