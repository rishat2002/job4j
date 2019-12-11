package ru.job4j.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operation {
    private Map<User, List<Account>> users = new HashMap<User, List<Account>>();

    public void addUser(User user) {
        users.putIfAbsent(user, user.getAccount());
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getKey().addAccount(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getKey().addAccount(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                list = entry.getKey().getAccount();
            }
        }
        return list;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, int amount) throws NullPointerException{
        boolean successoper = false;
        try{
        User src = null;
        User dest = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(srcPassport)) {
                src = entry.getKey();
            }
            if (entry.getKey().getPassport().equals(destPassport)) {
                dest = entry.getKey();
            }
        }
        Account destacc=null;
        for (Account destAccount :dest.getAccount()) {
            if (destAccount.getRequisites().equals(dstRequisite)) {
                destacc=destAccount;
            }
        }
        for (Account srcAccount : src.getAccount()) {
            if (srcAccount.getRequisites().equals(srcRequisite)) {
               if(srcAccount.getValue()>=amount) {
                   srcAccount.setValue(srcAccount.getValue()-amount);
                   destacc.setValue(destacc.getValue()+amount);
                   successoper=true;
               }
            }
        }}
        catch (NullPointerException e) {
            return successoper;
        }
        return successoper;
    }

    public static void main(String[] args) {
        Operation newoperation=new Operation();
        User user1=new User("vasilev","10001",new ArrayList<>());
        User user2=new User("petrov","20002",new ArrayList<>());
        user1.addAccount(new Account(20000,"123456"));
        user1.addAccount(new Account(1000,"103456"));
        user2.addAccount(new Account(3000,"654321"));
        newoperation.addUser(user1);
        newoperation.addUser(user2);
        newoperation.transferMoney("10001","123456","20002","654321",6000);
        System.out.println(user2.getAccount().get(0).getValue());
        System.out.println(user1.getAccount().get(0).getValue());
        newoperation.transferMoney("10001","123456","10001","103456",3000);
        System.out.println(user1.getAccount().get(0).getValue());
        System.out.println(user1.getAccount().get(1).getValue());
        System.out.println(newoperation.transferMoney("10001","123456","20002","654321",400000));
        System.out.println(newoperation.transferMoney("10001","12356","2002","654321",6000));
    }
}
