package ru.job4j.Bank;

import java.util.List;
import java.util.Map;

public class Account {
  private int value;
  private String requisites;

    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
    public boolean transfer(Account account, int amount) {
        boolean n=false;
       if (this.getValue()>=amount) {
           this.setValue(this.getValue()-amount);
           account.setValue(account.getValue()+amount);
           n=true;
       }
       return n;
    }

}
