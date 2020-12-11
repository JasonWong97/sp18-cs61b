package synthesizer;

/**
 * @ClassName AbstractBoundedQueue
 * @Description: TODO
 * @Author Jiacheng Weng
 * @Date 12/11/20 12:18 上午
 * @Version V1.0
 **/
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

//    public int capacity();
//
//    public int fillCount();

//    public boolean isEmpty();
//
//    public boolean isFull();

    public abstract T peek();

    public abstract T dequeue();

    public abstract void enqueue(T x);

//    abstract void moveTo(double deltaX, double deltaY);
}
