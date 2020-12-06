/**
 * @ClassName LinkedListDeque
 * @Description: TODO
 * @Author Jiacheng Weng
 * @Date 11/30/20 1:52 下午
 * @Version V1.0
 **/
public class LinkedListDeque<T> implements Deque<T>{

    private class ListNode {
        T item;
        ListNode prev;
        ListNode next;

    }

    private ListNode sentinel;
    private int size;


    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinel = new ListNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Creates a deep copy of other
     *
     * @param other
     */
//    public LinkedListDeque(LinkedListDeque other) {
//        LinkedListDeque t = new LinkedListDeque();
//        ListNode node = other.sentinel.next;
//        while (node != other.sentinel) {
//            node = node.next;
//            t.addLast(node.item);
//        }
//    }

    /**
     * Adds an item of type T to the front of the deque.
     *
     * @param item
     */
    @Override
    public void addFirst(T item) {

        ListNode temp = new ListNode();
        temp.item = item;
        temp.prev = sentinel;
        temp.next = sentinel.next;

        if (sentinel.next == sentinel) {
            sentinel.prev = temp;
        }
        temp.next = sentinel.next;
        temp.prev = sentinel;
        sentinel.next.prev = temp;
        sentinel.next = temp;
        ++size;
    }

    /**
     * Adds an item of type T to the back of the deque.
     *
     * @param item
     */
    @Override
    public void addLast(T item) {
        ListNode temp = new ListNode();
        temp.item = item;
        temp.prev = sentinel;
        temp.next = sentinel.next;
        temp.prev = sentinel.prev;
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        temp.next = sentinel;
        ++size;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     *
     * @param
     */
    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /**
     * Returns the number of items in the deque.
     *
     * @param
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     *
     * @param
     */
    @Override
    public void printDeque() {
        ListNode temp = sentinel.next;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
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
        if (sentinel.next == sentinel) {
            return null;
        }
        T t = sentinel.next.item;

        if (sentinel.next == sentinel.prev) {
            sentinel.prev = sentinel;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        --size;
        return t;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     * @param
     */
    @Override
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T t = sentinel.prev.item;

        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        --size;
        return t;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.If no such item exists, returns null. Must not alter the deque!
     *
     * @param index
     */
    @Override
    public T get(int index) {
        ListNode temp = sentinel;
        for (int i = 0; i < index + 1; i++) {
            temp = temp.next;
            if (temp == sentinel) {
                return null;
            }
        }
        return temp.item;
    }

    /**
     * Same as get, but uses recursion.
     *
     * @param index
     * @return
     */
    public T getRecursive(int index) {
        ListNode t = getRecursiveHelper(sentinel.next, index);

        return t == null ? null : t.item;
    }

    private ListNode getRecursiveHelper(ListNode node, int in) {
        if (node == sentinel) {
            return null;
        }
        if (in == 0) {
            return node;
        }
        return getRecursiveHelper(node.next, --in);
    }
}
