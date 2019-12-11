package ru.job4j.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operation {
   public Map<User, List<Account>> users = new HashMap<User, List<Account>>();

    public void addUser(User user) {
        users.putIfAbsent(user, user.getAccount());
    }

    public void deleteUser(User user) {
        users.remove(user);
    }
    public User getUserByPassport(String passport) {
     User user = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                user=entry.getKey();
            }
        }
        return user;
    }
    public Account getAccount(User user, String req) {
        Account acc=null;
        for (Account destAccount :user.getAccount()) {
            if (destAccount.getRequisites().equals(req)) {
                acc=destAccount;
            }
        }
        return acc;
    }

    public void addAccountToUser(String passport, Account account) {
        this.getUserByPassport(passport).addAccount(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
          this.getUserByPassport(passport).delAccount(account);
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        list=this.getUserByPassport(passport).getAccount();
        return list;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, int amount) throws NullPointerException{
        boolean successoper = false;
        try{
        User src = this.getUserByPassport(srcPassport);;
        User dest = this.getUserByPassport(destPassport);
        Account destacc=this.getAccount(dest,dstRequisite);
        Account srcacc=this.getAccount(src,srcRequisite);
        successoper=srcacc.transfer(destacc,amount);
        }
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
/*1. Многие методы используют user, которого нужно найти по паспорту, поэтому целесообразно вынести этот поиск
в метод getUserByPassport(String passport)
2. Поиск счета так же лучше вынести для повышения читабельности getAccount(User user, String req)
3. Логику перечисления со счета на другой счет лучше вынести в класс Account в метод
transfer(Account account, double amount)
 */