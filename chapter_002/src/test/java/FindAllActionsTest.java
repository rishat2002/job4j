import  org.junit.Test;
import ru.job4j.tracker.ShowAction;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.Tracker;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindAllActionsTest {

   @Test
    public void whenCheckOutput() {
        Consumer<String>cons=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAction act = new ShowAction();
        act.execute(new StubInput(new String[] {}), tracker,cons );
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }


}