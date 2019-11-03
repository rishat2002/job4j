package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class SqMaxTest {
    @Test
    public void  max() {
        int result = SqMax.max(30,20,31,16);

        assertThat(result,is(31));

    }
}
