package Syncronized;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Set<User> userList = new HashSet<>();

    public synchronized Set<User> getUserList() {
        return userList;
    }

    public synchronized Optional<User> findUser(User user) {
        return Optional.ofNullable(userList.stream().filter(x -> x.equals(user)).findFirst().orElse(null));
    }

    public synchronized boolean add(User user) {
        return userList.add(user);
    }

    public synchronized boolean delete(User user) {
        if (!this.findUser(user).isPresent()) {
            return false;
        }
        return userList.remove(this.findUser(user).get());
    }

    public boolean update(User user) {
        if (!this.findUser(user).isPresent()) {
            return false;
        }
        this.findUser(user).get().setAmount(user.getAmount());
        return true;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        Optional<User> streamForUserfrom = userList.stream().filter(x -> x.getId() == fromId).findFirst();
        System.out.println(streamForUserfrom.isPresent());
        Optional<User> streamForUserto = userList.stream().filter(x -> x.getId() == toId).findFirst();
        if (streamForUserfrom.isEmpty() || streamForUserto.isEmpty()) {
         return false;
        }
        User fromUser = streamForUserfrom.get();
        User toUser =streamForUserto.get();
        if (fromUser.getAmount() >= amount) {
            fromUser.setAmount(fromUser.getAmount() - amount);
            toUser.setAmount(toUser.getAmount() + amount);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
    UserStorage u1=new UserStorage();
    User user1= new User(1,40);
    User user2= new User(2,50);
    User user3= new User(3,80);
    User user4= new User(4,120);
    u1.add(user1);
    u1.add(user2);
    u1.add(user3);
    u1.add(user4);
    System.out.println(u1.getUserList().size());
    System.out.println(u1.delete(user1)+" "+u1.getUserList().size());
    System.out.println(u1.delete(new User(9,340))+" "+u1.getUserList().size());
    System.out.println(u1.update(new User(2,220))+" "+u1.findUser(user2).get().getAmount());
    System.out.println(u1.transfer(3,4,10)+" "+u1.findUser(user4).get().getAmount()+" "+u1.findUser(user3).get().getAmount());
    }
}
