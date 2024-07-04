import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertEquals(false, palindrome.isPalindrome("cat"));
        assertEquals(true, palindrome.isPalindrome("a"));
        assertEquals(true, palindrome.isPalindrome(""));
        assertEquals(true, palindrome.isPalindrome("A"));
        assertEquals(true, palindrome.isPalindrome("racecar"));
        assertEquals(true, palindrome.isPalindrome("noon"));

        CharacterComparator cc = new OffByOne();
        assertEquals(true, palindrome.isPalindrome("boa", cc));
        assertEquals(true, palindrome.isPalindrome("a", cc));
        assertEquals(true, palindrome.isPalindrome("", cc));
        assertEquals(true, palindrome.isPalindrome("A", cc));
        assertEquals(true, palindrome.isPalindrome("acdb", cc));
        assertEquals(false, palindrome.isPalindrome("pctsq", cc));

    }
}
