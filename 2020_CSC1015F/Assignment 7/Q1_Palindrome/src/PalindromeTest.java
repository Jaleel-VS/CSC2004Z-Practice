import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromeTest {
    Palindrome pTest = new Palindrome(); 
    @Test
    public void test1() {
        assertEquals(true, pTest.isPalindrome("able was I ere I saw elba"));

    }

    @Test
    public void test2() {
        assertEquals(false, pTest.isPalindrome("elba is a noob"));
    }

    @Test
    public void test3() {
        assertEquals(true, pTest.isPalindrome(""));
    }

    @Test
    public void test4() {
        assertEquals(true, pTest.isPalindrome("l"));
    }
}
