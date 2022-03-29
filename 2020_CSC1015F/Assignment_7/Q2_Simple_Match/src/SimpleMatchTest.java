import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SimpleMatchTest {

    SimpleMatch s = new SimpleMatch();

    @Test
    public void test1() {
        assertEquals(true, s.doesMatch("", ""));
    }

    @Test
    public void test2() {
        assertEquals(false, s.doesMatch("le?d", "led"));
    }

    @Test
    public void test3() {
        assertEquals(true, s.doesMatch("l??d", "lend"));
    }

    @Test
    public void test4() {
        assertEquals(false, s.doesMatch("lea?", "read"));
    }

    @Test
    public void test5() {
        assertEquals(true, s.doesMatch("", ""));
    }
}

