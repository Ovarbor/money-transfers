package ru.banking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.banking.exception.ConflictException;
import ru.banking.exception.ExceptionsHandler;

import java.math.BigDecimal;
import java.util.Random;

public class TransferService {

    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);
    private static final ExceptionsHandler exceptionsHandler = new ExceptionsHandler();

    public Account createAccount() {
        Account account = new Account();
        logger.info("account created!");
        return account;
    }

    public void sendMoney(Account sender, Account recipient) throws ConflictException {
        BigDecimal value = BigDecimal.valueOf(getRandomNumberUsingNextInt(1, 1000));
        if (sender.getMoney().compareTo(value) > 0) {
            sender.setMoney(sender.getMoney().subtract(value));
            recipient.setMoney(recipient.getMoney().add(value));
            logger.info("send money " + value + " from sender with id: " + sender.getId() +
                    " to recipient with id: " + recipient.getId() + " ok!" +
                    "sender balance now: " + sender.getMoney() +
                    " recipient balance now: " +recipient.getMoney());
        } else {
             exceptionsHandler.conflictException(new ConflictException("insufficient funds in account with id: "
                     + sender.getId() + ", money to send " + value + " sender balance: " + sender.getMoney()));
        }
    }

    private static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
