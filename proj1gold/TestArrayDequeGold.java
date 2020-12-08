import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testDeques() {

        int[] arr = new int[9];

        for (int randCnt = 0; randCnt < 2000; randCnt++) {
            StudentArrayDeque<Integer> deq = new StudentArrayDeque<>();
            ArrayDequeSolution<Integer> deqsol = new ArrayDequeSolution<>();
            for (int arrLen = 0; arrLen < arr.length; arrLen++) {
                arr[arrLen] = (int) (Math.random() * 100);
            }

            String operations = "";
            for (int arrLen = 0; arrLen < arr.length; arrLen++) {
                if (arr[arrLen] < 25) {
                    deq.addFirst(arr[arrLen]);
                    deqsol.addFirst(arr[arrLen]);
                    /*System.out.println(deqsol.get(0));
                    System.out.println(deq.get(0));
                    System.out.println();*/
                    operations += "addFirst(" + arr[arrLen] + ") ";
                    assertEquals(operations, deqsol.get(0), deq.get(0));
                } else if (arr[arrLen] < 50) {
                    deq.addLast(arr[arrLen]);
                    deqsol.addLast(arr[arrLen]);
                    /*System.out.println(deqsol.get(deqsol.size()-1));
                    System.out.println(deq.get(deqsol.size()-1));
                    System.out.println();*/
                    operations += "addLast(" + arr[arrLen] + ") ";
                    assertEquals(operations, deqsol.get(deqsol.size() - 1),deq.get(deqsol.size() - 1));
                } else if (arr[arrLen] < 75 && deq.size() != 0) {
                    operations += "removeFirst() ";
                    if (deq.size() != 0) {
                        Integer x = deq.removeFirst();
                        Integer y = deqsol.removeFirst();
                        /*System.out.println(x);
                        System.out.println(y);
                        System.out.println(operations);
                        operations += "removeFirst() ";*/
                        assertEquals(operations, y, x);
                    }
                } else {
                    operations += "removeLast() ";
                    if (deq.size() != 0) {
                        Integer x = deq.removeLast();
                        Integer y = deqsol.removeLast();
                        /*System.out.println(x);
                        System.out.println(y);
                        System.out.println();
                        operations += "removeLast() ";*/
                        assertEquals(operations, y, x);
                    }
                }
            }
            //System.out.println(operations);
        }
    }
}
