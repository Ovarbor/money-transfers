package ru.banking;

import ru.banking.exception.ConflictException;

import java.util.Random;
import java.util.stream.IntStream;

public class ThreadService implements Runnable {

    private static final TransferService transferService = new TransferService();

    private int count;
    private Account sender;
    private Account recipient;
    Random random = new Random();

    public ThreadService(Account sender, Account recipient, int count) {
        this.sender = sender;
        this.recipient = recipient;
        this.count = count;
    }

    @Override
    public void run() {
        IntStream.range(0, count).forEachOrdered(i -> {
            try {
                transferService.sendMoney(sender, recipient);
            } catch (ConflictException e) {
                System.out.println(e.getMessage());;
            }
            try {
                java.lang.Thread.sleep(random.nextInt(1000, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getRecipient() {
        return recipient;
    }

    public void setRecipient(Account recipient) {
        this.recipient = recipient;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
