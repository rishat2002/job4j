package API;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> adres=profiles.stream().map(prof->prof.getAddress()).collect(Collectors.toList());
        return adres;
    }

    public static void main(String[] args) {
        Profiles pro=new Profiles();
        List<Profile> profiles=List.of(new Profile(new Address("tyla","smirnova",13,210)),new Profile(new Address("tyla","smirnova",26,220)));
        List<Address> alladress=pro.collect(profiles);
        System.out.println(alladress);
    }
}
