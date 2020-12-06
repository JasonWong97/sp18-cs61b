import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('a', 'E'));
        assertFalse(offByOne.equalChars('A', 'E'));
        assertFalse(offByOne.equalChars('A', 'e'));

        assertTrue(offByOne.equalChars('a', 'E'));
        assertTrue(offByOne.equalChars('A', 'E'));
        assertTrue(offByOne.equalChars('A', 'e'));

        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('%', '&'));
    }

}
