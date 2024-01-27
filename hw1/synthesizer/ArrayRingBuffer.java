// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;
    private List<T> list = new ArrayList<>(); // for the creation of the array rb []
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
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
            last = (last + this.capacity -1) % this.capacity;
            fillCount -= 1;
            return rb[(last+1)%this.capacity];
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
        return rb[(last + this.capacity -1) % this.capacity];

    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
