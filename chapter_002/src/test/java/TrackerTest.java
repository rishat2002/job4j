import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void  findByNameTest() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        Item previous1 = new Item("test2");
        tracker.add(previous);
        tracker.add(previous1);
        List<Item> resul=tracker.findByName("test2");
        List<Item> n=new ArrayList<Item>();
        n.add(previous1);
        assertArrayEquals(resul.toArray(),n.toArray());
    }
    @Test
    public void DeleteTest() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        Item previous1 = new Item("test2");
        tracker.add(previous);
        tracker.add(previous1);
        tracker.delete(previous1.getId());
        List<Item> resul=tracker.findall();
        List<Item> n=new ArrayList<Item>();
        n.add(previous);
        assertArrayEquals(resul.toArray(),n.toArray());

    }
    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        Item previous1 = new Item("test2");
        tracker.add(previous);
        tracker.add(previous1);
        Item next = new Item("test3");
        tracker.add(next);
        Item item=tracker.findById(next.getId());
        assertThat(item,is(next));

    }}
