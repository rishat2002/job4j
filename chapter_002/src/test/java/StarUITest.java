import org.junit.Test;
import ru.job4j.ru.job4j.tracker.Input;
import ru.job4j.ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class StarUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC","Fix mouse"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("first item");
        Item item1 = new Item("second item");
        Item item2 = new Item("thirty item");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        String[] answers = {
                item1.getId() // id сохраненной заявки в объект tracker.
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item delete = tracker.findAll()[1];
        assertThat(delete.getName(), is("thirty item"));
    }

}

