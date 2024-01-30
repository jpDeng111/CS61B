// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    private int index;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0; // should I use this.fillCount?
        this.capacity = capacity;
//        T[] rb = (T[]) Array.newInstance(list.get(0).getClass(), this.capacity);
        rb = (T[]) new Object[this.capacity]; // This should really be memorized. Problems about the programming language is not the core problem
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount < this.capacity){
            rb[last] = x;
            last = (last + 1) % this.capacity;
            fillCount += 1;
        }
        else {
            throw new RuntimeException("Ring buffer overflow");
        }


    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (fillCount > 0) { // I think it's not necessary to delete the element in the array, just ignoring is ok
            first = (first + 1) % this.capacity;
            fillCount -= 1;
            return rb[(first - 1 + capacity) % this.capacity];
        }
        else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];

    }

    @Override
    public boolean hasNext() {
        if (index < last-1 ) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        return rb[index++];
    }

    @Override
    public Iterator<T> iterator() {
        index = first;
        return null;
    }

}
