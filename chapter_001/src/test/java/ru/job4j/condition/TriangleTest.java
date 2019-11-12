package ru.job4j.condition;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TriangleTest {
    @Test
    public void areatest() {
        Point ap=new Point(2,0);
        Point bp=new Point(3,1);
        Point cp=new Point(1,1);
        Triangle triangle1=new Triangle(ap,bp,cp);
        double methodresult=triangle1.area();
        double trueresult=0.99;
        Assert.assertEquals(trueresult,methodresult,0.01);
        Point a=new Point(9,0);
        Point b=new Point(3,1);
        Point c=new Point(1,1);
        Triangle triangle2=new Triangle(a,b,c);
        double methodresult1=triangle1.area();
        double trueresult1=-1;
        Assert.assertEquals(trueresult,methodresult,0.01);
    }

}
