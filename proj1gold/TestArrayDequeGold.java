import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @ClassName TestArrayDequeGold
 * @Description: TODO
 * @Author Jiacheng Weng
 * @Date 12/8/20 7:07 下午
 * @Version V1.0
 **/
public class TestArrayDequeGold {

    @Test
    public void testArrayDequeGold() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

//        addLast
        for (int i = 0; i < 10; i += 1) {
            Integer num = StdRandom.uniform(100);
            sad.addLast(num);
            ads.addLast(num);
        }
        for (int i = 0; i < 10; i += 1) {
            Integer actual =ads.get(i);
            Integer expected =sad.get(i);
            assertEquals("addLast()\n",actual,expected);
        }

//        removeLast
        for (int i = 0; i < 10; i += 1) {
            Integer actual =ads.removeLast();
            Integer expected =sad.removeLast();
            assertEquals("removeLast()\n",actual,expected);
        }




//        addFirst
        for (int i = 0; i < 10; i += 1) {
            Integer num = StdRandom.uniform(100);
            sad.addFirst(num);
            ads.addFirst(num);
        }
        for (int i = 0; i < 10; i += 1) {
            Integer actual =ads.get(i);
            Integer expected =sad.get(i);
            assertEquals("addFirst()\n",actual,expected);
        }


//        removeFirst
        for (int i = 0; i < 10; i += 1) {
            Integer actual =ads.removeFirst();
            Integer expected =sad.removeFirst();
            assertEquals("removeFirst()\n",actual,expected);
        }
    }
}
