import org.junit.Test;
import ru.job4j.ru.job4j.tracker.StartUI;
import ru.job4j.ru.job4j.tracker.StubAction;
import ru.job4j.ru.job4j.tracker.UserAction;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.Tracker;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InitTest {
    @Test
    public void whenPrtMenu() {
        Tracker tracker=new Tracker();
        Consumer<String> cons=new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI(input,tracker,cons).init(input, new Tracker(), new UserAction[] { action });
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
