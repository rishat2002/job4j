package syncronizedpart;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    public synchronized boolean update(User user) {
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
        User toUser = streamForUserto.get();
        if (fromUser.getAmount() >= amount) {
            fromUser.setAmount(fromUser.getAmount() - amount);
            toUser.setAmount(toUser.getAmount() + amount);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
