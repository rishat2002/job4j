package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class MaxTest {
@Test public void whenMax1To2Then2() {
    Max newMax=new Max();
    int result=newMax.max(18,5);
    int result1=newMax.max(22,6,9);
    int result2=newMax.max(12,100,54,53);
    assertThat(result,is(18));
    assertThat(result1,is(22));
    assertThat(result2,is(100));

}

}
