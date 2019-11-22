package job4j.StrategyTest;

import job4j.stragery.Paint;
import job4j.stragery.Square;
import job4j.stragery.Triangle;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("@@@@\n")
                                .append("@  @\n")
                                .append("@  @\n")
                                .append("@@@@\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );

        System.setOut(stdout);
    }
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append("  1  \n")
                                .append(" 111 \n")
                                .append("11111\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );

        System.setOut(stdout);
    }
}
