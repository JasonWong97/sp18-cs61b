import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        Assert.assertFalse(offByOne.equalChars('a', 'b'));
        Assert.assertTrue(offByOne.equalChars('a', 'a'));
    }

}
