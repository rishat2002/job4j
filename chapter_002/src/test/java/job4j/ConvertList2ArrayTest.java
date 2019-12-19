package job4j;
import org.junit.Test;
import ru.job4j.list.ConvertList2Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        List<Integer>list2=List.of(1,2,3,4,5,6);
        int[][] result = list.toArray(list2,3);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5,6}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when7ElementsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        List<Integer>list2=List.of(1,2,3,4);
        int[][] result = list.toArray(list2,2);
        int[][] expect = {
                {1, 2},
                {3, 4}
        };
        assertThat(result, is(expect));
    }
}
