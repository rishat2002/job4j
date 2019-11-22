package job4j.StrategyTest;

import job4j.stragery.Square;
import job4j.stragery.Triangle;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
public class SquareAndTriangleTest {
    @Test
    public void SquareandTriangle() {
        StringBuilder result = new StringBuilder();
        result.append("@@@@\n");
        result.append("@  @\n");
        result.append("@  @\n");
        result.append("@@@@\n");
        String res=result.toString();
        Square square=new Square();
        String execute=square.draw();
        assertEquals(res,execute);
    }
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  1  \n")
                                .append(" 111 \n")
                                .append("11111\n").toString()
                )
        );
    }
}
