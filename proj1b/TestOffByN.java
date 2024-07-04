import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static int difference = 5;
    static CharacterComparator offByN = new OffByN(difference);

    // Your tests go here.
    @Test
    public void TestequalChars() {
        assertEquals(false, offByN.equalChars('a', 'b'));
        assertEquals(true, offByN.equalChars('a', 'f'));
        assertEquals(true, offByN.equalChars('b', 'g'));
        assertEquals(false, offByN.equalChars('a', 'e'));
        assertEquals(false, offByN.equalChars('z', 'a'));
        assertEquals(false, offByN.equalChars('a', 'a'));
        assertEquals(true, offByN.equalChars('f', 'a'));

    }

}
