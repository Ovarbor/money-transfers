package ru.banking;
public class Main {

    public static final TransferService transferService = new TransferService();

    public static void main(String[] args) {

        Account account1 = transferService.createAccount();
        Account account2 = transferService.createAccount();
        Account account3 = transferService.createAccount();
        Account account4 = transferService.createAccount();
        Thread threadOne = new Thread(new ThreadService(account1, account2, 15));
        threadOne.start();
        Thread threadTwo = new Thread(new ThreadService(account3, account4, 15));
        threadTwo.start();
        System.out.println(account3.getMoney());
    }
}