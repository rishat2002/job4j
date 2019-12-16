package ru.job4j.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Operation {
   public Map<User, List<Account>> users = new HashMap<User, List<Account>>();

    public void addUser(User user) {
        users.putIfAbsent(user, user.getAccount());
    }

    public void deleteUser(User user) {
        users.remove(user);
    }
    public User getUserByPassport(String passport) {
        List<User>list=users.entrySet().stream().map(n->n.getKey()).filter(x->x.getPassport().equals(passport)).collect(Collectors.toList());
        if (list.isEmpty()) { return null; }
        return list.get(0);
    }
    public Account getAccount1(User user, String req) {
        List<Account>list=user.getAccount().stream().filter(n->n.getRequisites().equals(req)).collect(Collectors.toList());
        if (list.isEmpty()) {return null; };
        return list.get(0);
    }

    public void addAccountToUser(String passport, Account account) {
        if (this.getUserByPassport(passport)==null) { System.out.println("passport not found"); }
        this.getUserByPassport(passport).addAccount(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (this.getUserByPassport(passport)==null) { System.out.println("passport not found"); }
          this.getUserByPassport(passport).delAccount(account);
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        list=this.getUserByPassport(passport).getAccount();
        if (this.getUserByPassport(passport)==null) { System.out.println("passport not found"); }
        return list;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, int amount) {
        boolean successoper = false;
        User src = this.getUserByPassport(srcPassport);
        User dest = this.getUserByPassport(destPassport);
        Account destacc=this.getAccount1(dest,dstRequisite);
        Account srcacc=this.getAccount1(src,srcRequisite);
        if (src==null || dest==null || destacc==null || srcacc==null) {
            return successoper;
        }
        successoper=srcacc.transfer(destacc,amount);
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
        System.out.println(newoperation.getUserByPassport("20002"));
        System.out.println(newoperation.getUserByPassport("5435"));
        newoperation.transferMoney("10001","123456","20002","654321",6000);
        System.out.println(user2.getAccount().get(0).getValue());
        System.out.println(user1.getAccount().get(0).getValue());
        newoperation.transferMoney("10001","123456","10001","103456",3000);
        System.out.println(user1.getAccount().get(0).getValue());
        System.out.println(user1.getAccount().get(1).getValue());
    }
}
/*1. Многие методы используют user, которого нужно найти по паспорту, поэтому целесообразно вынести этот поиск
в метод getUserByPassport(String passport)
2. Поиск счета так же лучше вынести для повышения читабельности getAccount(User user, String req)
3. Логику перечисления со счета на другой счет лучше вынести в класс Account в метод
transfer(Account account, double amount)
 */