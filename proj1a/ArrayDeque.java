/**
 * @ClassName ArrayDeque
 * @Description: TODO
 * @Author Jiacheng Weng
 * @Date 12/4/20 9:44 下午
 * @Version V1.0
 **/
public class ArrayDeque<T> {

    private T[] a;
    private int size;
    private int firstIndex;
    private int lastIndex;
    private static final int FACTOR_EXPAND = 2;
    private static final double FACTOR_USAGE = 0.25;


    private void checkSize() {
        int emptySpace = 0;
        boolean aType = false;
        if (lastIndex > firstIndex) {
            emptySpace = a.length - (lastIndex - firstIndex + 1);
            aType = true;
        } else {
            emptySpace = firstIndex - lastIndex - 1;
        }
        if (emptySpace == 0) {
            T[] tt = (T[]) new Object[a.length * FACTOR_EXPAND];
            if (aType) {
                System.arraycopy(a, firstIndex, tt, 0, lastIndex - firstIndex + 1);
                lastIndex = lastIndex - firstIndex;
                firstIndex = 0;
            } else {
                System.arraycopy(a, firstIndex, tt, 0, a.length - firstIndex);
                System.arraycopy(a, 0, tt, a.length - firstIndex, lastIndex + 1);
                lastIndex = lastIndex + a.length - firstIndex;
                firstIndex = 0;
            }
            a = tt;
        }
        if (emptySpace > a.length * (1 - FACTOR_USAGE)) {
            T[] tt = (T[]) new Object[a.length * FACTOR_EXPAND / 4];
            if (aType) {
                System.arraycopy(a, firstIndex, tt, 0, lastIndex - firstIndex + 1);
                lastIndex = lastIndex - firstIndex;
                firstIndex = 0;
            } else {
                System.arraycopy(a, firstIndex, tt, 0, a.length - firstIndex);
                System.arraycopy(a, 0, tt, a.length - firstIndex, lastIndex + 1);
                lastIndex = lastIndex + a.length - firstIndex;
                firstIndex = 0;
            }
            a = tt;
        }
    }

    /**
     * Creates an empty linked list deque.
     */
    public ArrayDeque() {
        a = (T[]) new Object[8];
        size = 0;
    }

    /**
     * Creates a deep copy of other
     *
     * @param other
     */
    public ArrayDeque(ArrayDeque other) {

    }


    /**
     * Adds an item of type T to the front of the deque.
     * two situations: 1.the current capacity is enough,
     * 2.we need to enlarge the capacity
     *
     * @param item
     */
    public void addFirst(T item) {
        checkSize();
        if (firstIndex == 0) {
            firstIndex = a.length - 1;

        } else {
            firstIndex -= 1;
        }
        a[firstIndex] = item;
        ++size;
    }

    /**
     * Adds an item of type T to the back of the deque.
     *
     * @param item
     */
    public void addLast(T item) {
        checkSize();
        lastIndex += 1;
        a[lastIndex] = item;
        ++size;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     *
     * @param
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     *
     * @param
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     *
     * @param
     */
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
    public T removeFirst() {
        T temp;
        temp = a[firstIndex];
        if (firstIndex == a.length - 1) {
            firstIndex = 0;
        } else {
            firstIndex += 1;
        }


        --size;
        checkSize();
        return temp;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     * @param
     */
    public T removeLast() {
        T temp;
        temp = a[lastIndex];
        lastIndex -= 1;
        --size;
        checkSize();
        return temp;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.If no such item exists, returns null. Must not alter the deque!
     *
     * @param index
     */
    public T get(int index) {
        if (index < 0 || index > size) return null;
        if (firstIndex < lastIndex) {
            return a[firstIndex + index];
        } else {
            if (index < a.length - firstIndex) {
                return a[firstIndex + index];
            } else {
                return a[index - (a.length - firstIndex)];
            }
        }
    }
}
