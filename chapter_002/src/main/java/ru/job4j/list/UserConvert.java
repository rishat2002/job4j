package ru.job4j.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> user = new HashMap<Integer, User>();
        for (User n : list) {
            user.put(n.getId(), n);
        }
        return user;
    }

    public static void main(String[] args) {
        UserConvert con=new UserConvert();
        User use1=new User(203,"solo");
        User use2=new User(204,"save");
        User use3=new User(205,"resol");
        List<User>lis=new ArrayList<User>();
        lis.add(use1);
        lis.add(use2);
        lis.add(use3);
        for (Map.Entry entry:con.process(lis).entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
