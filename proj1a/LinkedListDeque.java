public class LinkedListDeque<T> implements Deque<T>{

    Node sentinel;
    private int size=0;
    /*constructor to create an empty deque*/
    public LinkedListDeque(){
//        this.sentinel.linkNext(null);
//        this.sentinel.linkPrevious(null);
          sentinel = new Node();
          sentinel.write(0);
    }

    /*get() method using recursive algorithm*/
    public T getRecursive(int index){
        if(index<0 || index >= size){
            return null;
        }
        else{
            return getRecursiveHelper(sentinel.next,index-1);
        }
    }

    /*Help the getRecursive()to get the index ith element*/
    public T getRecursiveHelper(Node node, int index){
        if(index == 0){
            Node target = node.next;
            return (T) target.getElement();
        }
        else{
            return getRecursiveHelper(node.next, index-1);
        }
    }

    /*Check whether the linked list deque is empty*/
    @Override
    public boolean isEmpty(){
        if(sentinel.next == null){
            return true;
        }
        else return false;
    }

    /*Get the size of the deque*/
    @Override
    public int size(){
//        Node pointer = sentinel;
//        int size_of_linkedlist = 0;
//        while(pointer.next != sentinel){
//            size_of_linkedlist  += 1;
//            pointer = pointer.next;
//        }
        return this.size;
    }

    /*Get the ith node in the linked node list*/
    @Override
    public T get(int index){
        if(index+1 < size()){
            Node pointer = sentinel;
            while(index+1 > 0){
                pointer = pointer.next;
                index -= 1;
            }
            return (T) pointer.getElement();/*Why?*/
        }
        else{
            return null;
        }
    }


    /*Adds an item of type T to the front of the deque.*/
    @Override
    public void addFirst(T item){
        Node first = new Node();
        first.write(item);
        if(sentinel.next != null) {
            Node initial_first = sentinel.next;
            first.next = initial_first;
            first.previous = sentinel;
            sentinel.next = first;
            initial_first.previous = first;
        }
        else{
            sentinel.next = first;
            first.previous = sentinel;
            first.next = sentinel;
            sentinel.previous = first;
        }
        size += 1;

    }

    /*Adds an item of type T to the back of the deque.*/
    @Override
    public void addLast(T item){
        if(isEmpty()){
            addFirst(item);
            return;
        }
        else{
            Node last =new Node(item);
            last.linkPrevious(sentinel.previous);/*Dont't know if it's ok*/
            last.linkNext(sentinel);
            Node lastPrevious = sentinel.previous;
            lastPrevious.linkNext(last);
            sentinel.linkPrevious(last);
            size += 1;
        }

    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        else{
            Node last = sentinel.previous;
            T item = (T) last.getElement();/*What type is the getElement()*/
            Node newLast = last.previous;
            last.linkPrevious(null);
            last.linkNext(null);//take the last off the list
            newLast.linkNext(sentinel);
            sentinel.linkPrevious(newLast);
            newLast.next = null;
            size -= 1;
            return item;
        }
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        else if(size == 1){
            Node first = sentinel.next;
            sentinel.next = null;
            size = 0;
            return (T) first.getElement();
        }
        else{

            Node first = sentinel.next;
            Node second = first.next;
            sentinel.linkNext(second);
            second.linkPrevious(sentinel);
            first.linkNext(null);
            first.linkPrevious(null);//take node first off the linked list
            size -= 1;
            return (T) first.getElement();
        }
    }
    @Override
    public void printDeque(){
        Node pointer = sentinel;
        if(isEmpty()){
            System.out.print("null");
        }
        else{
            for(int i=0; i<size; i++){
                pointer = pointer.next;
                System.out.print(pointer.getElement());
                System.out.print(" ");
            }
        }

    }



}
