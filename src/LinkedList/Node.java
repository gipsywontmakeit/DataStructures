package LinkedList;

public class Node<T> {
    private Node<T> next;

    private Node<T> previous;

    private T element;


    public Node() {
        next = previous = null;
        element = null;
    }

    public Node(T element) {
        next = previous = null;
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
