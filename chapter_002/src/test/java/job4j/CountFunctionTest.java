package job4j;
import org.junit.Test;
import ru.job4j.CountFunction;
import ru.job4j.Sort.Machine;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.log;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class CountFunctionTest {
    @Test
    public void TestFunctionLin() {
        CountFunction func1=new CountFunction();
        List<Double> list1=func1.diapason(3,5,(index)->{
            return index*3+3;
        });
        List<Double>list1result= Arrays.asList(12D, 15D);
        assertThat(list1,is(list1result));
    }
    @Test
    public void TestFunctionLinSquare() {
        CountFunction func1=new CountFunction();
        List<Double> list1=func1.diapason(3,5,(index)->{
            return index*index;
        });
        List<Double>list1result= Arrays.asList(9D, 16D);
        assertThat(list1,is(list1result));
    }
    @Test
    public void TestFunctionLog() {
        CountFunction func1=new CountFunction();
        List<Double> list1=func1.diapason(15,18,(index)->{
            return log(index);
        });
        for (int i=0;i<list1.size();i++) {
            list1.set(i,Math.ceil(list1.get(i)));
        }
        List<Double>list1result= Arrays.asList(3D, 3D,3D);
        assertThat(list1,is(list1result));
    }


}
