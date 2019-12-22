package job4j;
import org.junit.Test;
import ru.job4j.Departments;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }
    @Test
    public void sortAscTest() {
        List<String> input = Arrays.asList("k2","k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1","k2");
        Departments.sortAsc(input);
        List<String> result = input;
        assertThat(result, is(expect));
    }
    @Test
    public void sortDescTest() {
        List<String> input = Arrays.asList("k2","k1", "k1/sk1");
        List<String> expect = Arrays.asList("k2", "k1/sk1","k1");
        Departments.sortDesc(input);
        List<String> result = input;
        assertThat(result, is(expect));
    }

}