public interface Deque<T> {


    /**
     * Adds an item of type T to the front of the deque.
     *
     * @param item
     */
    void addFirst(T item);

    /**
     * Adds an item of type T to the back of the deque.
     *
     * @param item
     */
    void addLast(T item);

    /**
     * Returns true if deque is empty, false otherwise.
     *
     * @param
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the deque.
     *
     * @param
     */
    int size();

    /**
     * Prints the items in the deque from first to last, separated by a space.
     *
     * @param
     */
    void printDeque();

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     *
     * @param
     */
    T removeFirst();

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     * @param
     */
    T removeLast();

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.If no such item exists, returns null. Must not alter the deque!
     *
     * @param index
     */
    T get(int index);

}

