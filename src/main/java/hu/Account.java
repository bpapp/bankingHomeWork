package hu;

import hu.handler.TransferHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
public class Account {

    private String accNumber;
    private String owner;
    @Getter
    private BigDecimal balance;
    private String currencyCode;
    @Getter
    @Setter
    private boolean isActive;

    public void deposit(BigDecimal amount) throws IllegalAccessException {
        checkAccountIsActive();
        if (amount.compareTo(BigDecimal.ZERO) < 0) { // deposit value is negative
            System.out.println ("Error: Deposit amount is invalid.");
        }
        this.balance =  this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws IllegalAccessException {
        checkAccountIsActive();
        this.balance.subtract(amount);
    }

    private void checkAccountIsActive() throws IllegalAccessException {
        if (!isActive()) {
            throw new IllegalAccessException("This account not active");
        }
    }


    @AllArgsConstructor
    public class Transfer {

        private String otherAccNumber;

        public boolean sendMoney(BigDecimal amount) {
            if(balance.subtract(amount).compareTo(BigDecimal.ZERO) > 0 ) {
                return TransferHandler.doTheTransfer(otherAccNumber, amount);
            } else return false;
        }
    }

}