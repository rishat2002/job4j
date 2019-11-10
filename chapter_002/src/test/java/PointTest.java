import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.сondition.Point;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
public class PointTest {
    @Test
    public void distanceToPoint() {
        Point a = new Point(2, 2);
        Point b = new Point(6, 4);
        double methodResult=a.distance(b);
        double result=4.472;
        Assert.assertEquals(methodResult,result,0.01);
    }
}
