
public class ArrayDeque<T> {

    private Object[] array;
    int size = array.length;// The effective length of the array.


    public ArrayDeque() {
        array = (T[]) new Object();
    }

    public ArrayDeque(int newSize) {
        array = (T[]) new Object[newSize];
    }

    public T[] getArray() {
        return (T[])array;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            return array[index];
        }
    }
    /*Using boolean variable to judge if the deque is empty*/
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*How do I know it's a deqUe?*/
    public void addLast(T item) {
        if (isEmpty()) {
            T[] array_temp = (T[]) new Object[1];
            array_temp[0] = item;
            this.array = array_temp;
            size += 1;
        } else {
            ArrayDeque arrayTemp = new ArrayDeque(size + 1);
            T[] array_temp = (T[]) arrayTemp.getArray();
            System.arraycopy(this.array, 0, array_temp, 0, size);
            array_temp[size] = item;
            this.array = array_temp;
            size += 1;
        }
    }

    /*add the element item to the head of the array*/
    public void addFirst(T item) {
        if (isEmpty()) {
            T[] array_temp = (T[]) new Object[1];
            array_temp[0] = item;
            this.array = array_temp;
            size += 1;
        } else {
            ArrayDeque arrayTemp = new ArrayDeque(size + 1);
            T[] array_temp = (T[]) arrayTemp.getArray();
            System.arraycopy(this.array, 0, array_temp, 1, size);
            array_temp[0] = item;
            this.array = array_temp;
            size += 1;
        }

    }

    /*Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            T temp = (T) array[0];
            this.array = null;
            size -= 1;

            return temp;
        } else {
            size -= 1;
            T[] array_temp = (T[]) Object(size);
            T temp = (T) this.array[0];
            System.arraycopy(this.array, 1, array_temp, 0, size);
            array = array_temp;
            return temp;
        }

    }
    /*Remove the last element in the array*/
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            T temp = (T) array[0];
            this.array = null;
            size = 0;
            return temp;
        } else {
            size -= 1;
            T[] array_temp = (T[]) Object(size);
            T temp = (T) this.array[size];// get the last element
            System.arraycopy(this.array, 0, array_temp, 0, size);
            array = array_temp;
            return temp;
        }
    }
    /*Print all the elements in the deque*/
    public void printDeque(){
        for(int i=0; i<size; i++){
            System.out.print(this.array[i]);
            System.out.print(" ");
        }
    }





}
