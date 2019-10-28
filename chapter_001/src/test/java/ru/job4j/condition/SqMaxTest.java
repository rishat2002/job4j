package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class SqMaxTest {
    @Test
    public void  max() {
        int result = SqMax.max(12,20,13,16);

        assertThat(result,is(20));

    }
}
