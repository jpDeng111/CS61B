public class LinkedListDeque<T> {

    Node sentinel;
    private int size=0;
    /*constructor to create an empty deque*/
    public LinkedListDeque(){
        this.sentinel.linkNext(null);
        this.sentinel.linkPrevious(null);
    }

    /*get() method using recursive algorithm*/
    public T getRecursive(int index){
        if(index<0 || index >= size){
            return null;
        }
        else{
            getRecursiveHelper(sentinel.next,index-1);
        }
    }

    /*Help the getRecursive()to get the index ith element*/
    public T getRecursiveHelper(Node node, int index){
        if(index == 0){
            Node target = node.next;
            return (T) target.getElement();
        }
        else{
            getRecursiveHelper(node.next, index-1);
        }
    }

    /*Check whether the linked list deque is empty*/
    public boolean isEmpty(){
        if(sentinel.next == null){
            return true;
        }
        else return false;
    }

    /*Get the size of the deque*/
    public int size(){
        Node pointer = sentinel;
        while(pointer.next != sentinel){
            this.size += 1;
            pointer = pointer.next;
        }
        return this.size;
    }

    /*Get the ith node in the linked node list*/
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

    }

    /*Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        if(isEmpty()){
            addFirst(item);
        }
        else{
            Node last =new Node(item);
            last.linkPrevious(sentinel.previous);/*Dont't know if it's ok*/
            last.linkNext(sentinel);
            Node lastPrevious = sentinel.previous;
            lastPrevious.linkNext(last);
            sentinel.linkPrevious(last);

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
            return item;
        }
    }

    public T removeFirst(){
        if(isEmpty() || size == 1){
            return null;
        }
        else{

            Node first = sentinel.next;
            Node second = first.next;
            sentinel.linkNext(second);
            second.linkPrevious(sentinel);
            first.linkNext(null);
            first.linkPrevious(null);//take node first off the linked list
        }
    }



}
