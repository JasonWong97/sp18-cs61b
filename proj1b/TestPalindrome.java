import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }


    @Test
    public void testIsPalindrome() {

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));

        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("aaaaab"));

        System.out.println("OffByOne");
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("&%", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("abc", obo));
        assertTrue(palindrome.isPalindrome("abb", obo));

        System.out.println("OffByN");
        OffByN offBy5 = new OffByN(2);
        assertTrue(palindrome.isPalindrome("&%", offBy5));
        assertTrue(palindrome.isPalindrome("flake", offBy5));
        assertFalse(palindrome.isPalindrome("abc", offBy5));
        assertTrue(palindrome.isPalindrome("abb", offBy5));
    }
}
