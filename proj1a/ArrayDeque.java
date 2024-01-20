
public class ArrayDeque<T>  implements Deque<T> {

    private Object[] array;
    int size = 0;// The effective length of the array.
    int length = 100;// The space of the array.
    /*Didn't use the pointer variable-- It must exist because to
    * decrease the times that I create new array space, we need to
    * create large space at first and don't have tp create new space
    * until the space is filled*/
    int numOfPointer = size-1;
    int pointer=size-1;// = numOfPointer%size but initiallly the numOfPointer =0

    /*Move the pointer rightwards for one unit*/
    public void plusOne(){
        if(isEmpty()){
            return;
        }
        else{
            pointer = (pointer+1)%numOfPointer;
        }

    }
    /*Move the pointer leftwards*/
    public void minusOne(){
        if(isEmpty()){
            return;
        }
        else{
            pointer = Math.abs(pointer-1)%numOfPointer;
        }
    }
    /*Default Constructor */
    public ArrayDeque() {

        array = (T[]) new Object[length];
    }
    /*Constructor with an argument*/
    public ArrayDeque(int newSize) {
        array = (T[]) new Object[newSize];
    }

    public T[] getArray() {
        return (T[]) array;
    }

    @Override
    public int size() {
        return size;
    }

    /*Using the circular topology to build the deque*/
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            return (T) array[index];
        }
    }
    /*Using boolean variable to judge if the deque is empty*/
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    /*If the array is full, enlarge the space of the array*/
     public void grow(){
         T[] array_new = (T[]) new Object[length*2];
         length *= 2;
         System.arraycopy(this.array,0,array_new,0,size);
         this.array = array_new;
     }

     /*If the array is too empty, then shrink the array*/
    public void shrink(){
        T[] array_new = (T[]) new Object[length/2];
        length /= 2;
        System.arraycopy(this.array,0,array_new,0,size);
        this.array = array_new;
    }

    /*for addFirst and removeFirst. step >0, move right; step < 0, move left
    * we only need to move one step at a time */
    private void move(int step){//step can only be 1 and -1
        //Didn't realize that I used recursion in the function
        if(size<length & size>=length/2){
            if(step == 1){
                for(int i=size-1; i>0; i--){
                    array[i+1] = array[i];
                }
                size += 1;
            }
            else if (step == -1){
                for(int i=0; i<size; i++){
                    array[i] = array[i+1];
                }//Why did I feel disgusted? It's not hard. Just some easy operations stack together.
                size -= 1;
            }

        }
        else{
            if (size >= length){
                grow();
                move(1);
                /*Move right step*/
            }
            if(size < length/2){
                shrink();
                move(-1);
                /*Move the left step*/

            }

        }
    }
    /*How do I know it's a deque?*/
    @Override
    public void addLast(T item) {
        if (isEmpty()){
            this.array[0] = item;
            size += 1;
        }
        else{
            if(size<length){
                size += 1;
                array[size - 1] = item;
            }
            else{

                grow();
                array[size] = item;
                size += 1;
            }
        }
    }

    /*add the element item to the head of the array*/
    @Override
    public void addFirst(T item) {
        if(isEmpty()){
            array[0] = item;
            size += 1;
        }
        else{
            if(size <length) {
                for (int i = size - 1; i >= 0; i--) {
                    array[i + 1] = array[i];
                }
                array[0] = item;
                size += 1;
            }
            else{//The array is full before doing it
                grow();//this operation runs competely
                move(1);// size has incremented in the function
                array[0] = item;
                size += 1;
            }
        }

    }

    /*Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            T temp = (T) array[0];
            this.array = null;
            size = 0;
            return temp;
        } else {
            T temp = (T) array[0];
            move(-1);
            return temp;
        }

    }

    /*Remove the last element in the array*/
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            T temp = (T) array[0];
            this.array = null;
            size = 0;
            return temp;
        } else {
            size -=1;
            T temp = (T) this.array[size];// get the last element
            return temp;
        }
    }
    /*Print all the elements in the deque*/
    @Override
    public void printDeque(){
        for(int i=0; i<size; i++){
            System.out.print(this.array[i]);
            System.out.print(" ");
        }
    }


}
