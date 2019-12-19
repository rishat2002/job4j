package job4j.stragery;
import org.junit.Test;
import ru.job4j.sort1.SortUser;
import ru.job4j.sort1.User;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void testall () {
        SortUser sort1=new SortUser();
        User user1=new User(22,"pasha");
        User user2=new User(16,"pasha");
        User user3=new User(13,"slava");
        User user4=new User(14,"slava");
        List<User>lit=new ArrayList<>();
        lit.add(user1);
        lit.add(user2);
        lit.add(user3);
        lit.add(user4);
        sort1.sortByAllFields(lit);
        List<User>truelit=List.of(new User(16,"pasha"),new User(22,"pasha"),new User(13,"slava"),new User(14,"slava"));
        for (int i=0;i<lit.size();i++) {
            assertThat(lit.get(0),is(truelit.get(0)));
        }
    }

}
