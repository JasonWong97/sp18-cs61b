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

//        addLast  &  removeLast
        for (int i = 0; i < 10; i += 1) {
            Integer num = StdRandom.uniform(100);
            sad.addLast(num);
            ads.addLast(num);
        }
        for (int i = 0; i < 10; i += 1) {
            Integer actual =ads.removeLast();
            Integer expected =sad.removeLast();
            System.out.println("addFirst("+actual+")\n");
            System.out.println("addFirst("+expected+")\n");
//            assertEquals("removeLast()\n",actual,expected);
        }


//        addFirst  &  removeFirst
        for (int i = 0; i < 10; i += 1) {
            Integer num = StdRandom.uniform(100);
            sad.addFirst(num);
            ads.addFirst(num);
        }
        for (int i = 0; i < 10; i += 1) {
            Integer actual =ads.removeFirst();
            Integer expected =sad.removeFirst();
            System.out.println("addFirst("+actual+")\n");
            System.out.println("addFirst("+expected+")\n");
            assertEquals("removeFirst()\n",actual,expected);
        }

    }
}
