/**
 * @ClassName ArrayDeque
 * @Description: TODO
 * @Author Jiacheng Weng
 * @Date 12/4/20 9:44 下午
 * @Version V1.0
 **/
public class ArrayDeque<T> implements Deque<T> {

    private T[] a;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static final int FACTOR_EXPAND = 2;
    private static final double FACTOR_USAGE = 0.25;


    /**
     * Creates an empty linked list deque.
     */
    public ArrayDeque() {
        a = (T[]) new Object[8];
        size = 0;
        nextFirst = a.length / 2;
        nextLast = a.length / 2 + 1;
    }

    /**
     * Creates a deep copy of other
     *
     * @param other
     */
//    public ArrayDeque(ArrayDeque other) {
//
//    }
//


    /**
     * Adds an item of type T to the front of the deque.
     * two situations: 1.the current capacity is enough,
     * 2.we need to enlarge the capacity
     *
     * @param item
     */
    @Override
    public void addFirst(T item) {
        a[nextFirst] = item;
        ++size;
        nextFirst = minusOne(nextFirst);
        if (size == a.length) {
            resize(true);
        }
    }

    /**
     * Adds an item of type T to the back of the deque.
     *
     * @param item
     */
    @Override
    public void addLast(T item) {
        a[nextLast] = item;
        ++size;
        nextLast = plusOne(nextLast);
        if (size == a.length) {
            resize(true);
        }
    }

    /**
     * Returns true if deque is empty, false otherwise.
     *
     * @param
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     *
     * @param
     */
    @Override
    public int size() {
        if (size < 0) {
            return 0;
        }
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     *
     * @param
     */
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(this.get(i) + " ");
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     *
     * @param
     */
    @Override
    public T removeFirst() {
        nextFirst = plusOne(nextFirst);
        T temp = a[nextFirst];
        a[nextFirst] = null;
        --size;
        if ((size < FACTOR_USAGE * a.length) && a.length >= 16) {
            resize(false);
        }
        return temp;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     * @param
     */
    @Override
    public T removeLast() {
        nextLast = minusOne(nextLast);
        T temp = a[nextLast];
        a[nextLast] = null;
        --size;
        if ((size < FACTOR_USAGE * a.length) && a.length >= 16) {
            resize(false);
        }
        return temp;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.If no such item exists, returns null. Must not alter the deque!
     *
     * @param index
     */
    @Override
    public T get(int index) {
        if (size == 0) {
            return null;
        }
        return a[(index + plusOne(nextFirst)) % a.length];
    }

    private int minusOne(int index) {
        if (index == 0) {
            return a.length - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index) {
        return (index + 1) % a.length;
    }

    private void resize(boolean expandOrReduce) {
        T[] tt;
        if (expandOrReduce) {
            tt = (T[]) new Object[a.length * FACTOR_EXPAND];
        } else {
            tt = (T[]) new Object[a.length * FACTOR_EXPAND / 4];
        }
        int i = 0;
        int lastIndex = minusOne(nextLast);
        for (int j = plusOne(nextFirst); j != lastIndex; j = plusOne(j)) {
            tt[i] = a[j];
            i = plusOne(i);
        }
        tt[i] = a[lastIndex];
        a = tt;
        nextFirst = a.length - 1;
        nextLast = i + 1;
    }
}
