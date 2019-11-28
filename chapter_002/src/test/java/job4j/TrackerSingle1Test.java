package job4j;
import org.junit.Test;
import ru.job4j.tracker.TrackerSingle;
import ru.job4j.tracker.TrackerSingle1;
import ru.job4j.tracker.TrackerSingle2;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerSingle1Test {
    @Test
    public void getInstanceTest() {
        TrackerSingle tracker=TrackerSingle.getInstance();
        TrackerSingle tracker1=TrackerSingle.getInstance();
        assertThat(tracker, is (tracker));
    }
    @Test
    public void getInstanceTest1() {
        TrackerSingle1 tracker=TrackerSingle1.getInstance();
        TrackerSingle1 tracker1=TrackerSingle1.getInstance();
        assertThat(tracker, is (tracker1));
    }
    @Test
    public void getInstanceTest2() {
        TrackerSingle2 tracker= TrackerSingle2.getInstance();
        TrackerSingle2 tracker1=TrackerSingle2.getInstance();
        assertThat(tracker, is (tracker1));
    }
}
