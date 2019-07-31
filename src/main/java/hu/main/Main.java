package hu.main;

import hu.Account;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class Main {

    private static final String HUNGARIAN_FORINT = "HUF";
    private static final BigDecimal OPENING_BALANCE = new BigDecimal(10000000);

    public static void main(String[] args) {
        Account myAcc = new Account("12345678-87654321-77777777", "me", OPENING_BALANCE, HUNGARIAN_FORINT, true);
        Account.Transfer transferInstance = myAcc.new Transfer("22222222-22222222-22222222");
        transferInstance.sendMoney(new BigDecimal(500000));


        myAcc.setActive(false);
        try {
            myAcc.deposit(new BigDecimal(500000));
        } catch (IllegalAccessException e) {
            System.err.println("You can't deposit money because of not active!");
        }

    }
}
