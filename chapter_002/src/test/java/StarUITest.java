import org.junit.Test;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.StubAction;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class StarUITest {
    @Test
    public void whenExit() {
        Tracker tracker=new Tracker();
        Consumer<String> cons=new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI(input,tracker,cons).init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }

}


