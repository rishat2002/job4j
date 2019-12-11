package ru.job4j.Bank;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String passport;
    private List<Account> account = new ArrayList<Account>();

    public User(String name, String passport, ArrayList<Account> account) {
        this.name = name;
        this.passport = passport;
        this.account = account;
    }

    public void addAccount(Account newAccount) {
        account.add(newAccount);
    }

    public void delAccount(Account newAccount) {
        account.remove(newAccount);
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(passport);
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return user.passport.equals(passport) && user.name.equals(name);
    }

}
