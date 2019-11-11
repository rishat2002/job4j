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
        Point d =new Point(3,5,7);
        Point c=new Point(3,4,2);
        double medthodresult3d=d.distance3d(c);
        double methodResult=a.distance(b);
        double result=4.472;
        double result3d=5.09;
        Assert.assertEquals(methodResult,result,0.01);
        Assert.assertEquals(medthodresult3d,result3d,0.01);
    }
}
