package API;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> adres=profiles.stream().map(prof->prof.getAddress()).collect(Collectors.toList());
        adres.sort((s1,s2)->{
            return s1.getCity().compareTo(s2.getCity());
        });
        adres=adres.stream().distinct().collect(Collectors.toList());
        return adres;
    }

    public static void main(String[] args) {
        Profiles pro=new Profiles();
        List<Profile> profiles=List.of(new Profile(new Address("ayla","smirnova")),new Profile(new Address("cyla","smirnova")),
                new Profile(new Address("ayla","s")));
        List<Address> alladress=pro.collect(profiles);
        System.out.println(alladress);
    }
}
