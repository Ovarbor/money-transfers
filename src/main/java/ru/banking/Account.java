package ru.banking;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Account {

    private String id = UUID.randomUUID().toString();

    private BigDecimal money = BigDecimal.valueOf(10000);

    public Account() {
    }

    public Account(String id, BigDecimal money) {
        this.id = id;
        this.money = money;
    }

    public Account(BigDecimal money) {
        this.money = money;
    }


    public String getId() {
        return id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(getId(), account.getId()) && Objects.equals(getMoney(), account.getMoney());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMoney());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
