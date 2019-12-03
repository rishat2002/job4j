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
        List<Integer>list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        int[][] result = list.toArray(list1,3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0 ,0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when7ElementsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        List<Integer>list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        int[][] result = list.toArray(list1,2);
        int[][] expect = {
                {1, 2},
                {3, 4}
        };
        assertThat(result, is(expect));
    }
}
