package Iterator;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DimenArrayIteratorTest {

    private Iterator<Integer> it;

    @Before
    public void setUp(){
        it = new DimenArrayIterator(new int[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.next(), is(4));
        MatcherAssert.assertThat(it.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.next(), is(4));
        MatcherAssert.assertThat(it.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation () {
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(4));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(7));
        MatcherAssert.assertThat(it.hasNext(), is(false));
    }
}