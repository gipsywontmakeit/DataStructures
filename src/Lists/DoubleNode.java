package Lists;

/**
 * DoubleNode represents a node in a doubly linked list.
 * @param <T> the type of elements held in this collection
 */
public class DoubleNode<T> {

    /**
     * The element stored in this node.
     */
    private T element;

    /**
     * A reference to the next node in the list.
     */
    private DoubleNode<T> next;

    /**
     * A reference to the previous node in the list.
     */
    private DoubleNode<T> previous;

    /**
     * Creates an empty node.
     */
    public DoubleNode(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    /**
     * Creates a node storing the specified element.
     * @param element the element to be stored into the new node
     * @param next a reference to the node after this node
     * @param previous a reference to the node before this node
     */
    public DoubleNode(T element, DoubleNode<T> next, DoubleNode<T> previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Returns the element stored in this node.
     * @return the element stored in this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Returns the node that follows this one.
     * @return the node that follows the current one
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Returns the node that precedes this one.
     * @return the node that precedes the current one
     */
    public DoubleNode<T> getPrevious() {
        return previous;
    }

    /**
     * Sets the node that follows this one.
     * @param element the element to be set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Sets the node that follows this one.
     * @param next the node to be set
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Sets the node that precedes this one.
     * @param previous the node to be set
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Returns a string representation of this node.
     * @return a string representation of this node
     */
    @Override
    public String toString() {
        return "DoubleNode{" +
                "element=" + element +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}
