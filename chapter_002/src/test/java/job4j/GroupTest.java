package job4j;

import org.junit.Test;
import ru.job4j.lam.Group;
import ru.job4j.lam.Student;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GroupTest {
    @Test
    public void sectTest() {
        Set<String> newsect= new HashSet<String>();
        newsect.add("von");
        newsect.add("vod");
        newsect.add("vol");
        Set<String>newsect1= new HashSet<String>();
        newsect1.add("vod");
        newsect1.add("vol");
        Set<String>newsect2= new HashSet<String>();
        newsect2.add("von");
        newsect2.add("vol");
        List<Student> students= Arrays.asList(
                new Student("vasya",newsect),
                new Student("sema",newsect1));
        Map<String,Set<String>> truemap=new HashMap<>();
        Set<String>studforvol=new HashSet<>();
        studforvol.add("sema");
        studforvol.add("vasya");
        Set<String>studforvon=new HashSet<>();
        studforvon.add("vasya");
        Set<String>studforvod=new HashSet<>();
        studforvod.add("sema");
        studforvod.add("vasya");
        truemap.putIfAbsent("vol",studforvol);
        truemap.putIfAbsent("von",studforvon);
        truemap.putIfAbsent("vod",studforvod);
        assertThat(truemap, is(Group.sections(students)));
    }
}
