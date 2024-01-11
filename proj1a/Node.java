public class Node<T>{
    private T element;
    public Node previous;
    public Node next;

    public Node(){
        previous = null;
        next = null;
    }
    public Node(T item){
        element = item;
    }
    public void write(T ele){
        this.element =ele;
    }

    public T getElement(){
        return this.element;
    }
    public void linkNext(Node nex){
        next = nex;
    }

    public void linkPrevious(Node pre){
        previous = pre;
    }

}
