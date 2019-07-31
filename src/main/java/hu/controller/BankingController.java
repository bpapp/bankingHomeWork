package hu.controller;

import hu.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class BankingController {

    private final TransactionService transactionService;

    public Object transactionHistoryPrinting(long id) {
        transactionService.doTransactionHistoryPrinting(id);
        return null;
    }

    public void transactionHistoryWithAttributes(Date date, BigDecimal amount, BigDecimal balance) {
        transactionService.getTransactionHistoryWithAttr(date, amount, balance);
    }

}
