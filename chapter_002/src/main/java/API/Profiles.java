package API;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        Stream stream =profiles.stream().map(prof->prof.getAddress()).distinct();
        List <Address> adres= (List<Address>) stream.sorted(Comparator.comparing(Address::getCity)).collect(Collectors.toList());
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
