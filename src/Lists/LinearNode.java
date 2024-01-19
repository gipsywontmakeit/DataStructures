package Lists;

/**
 * LinearNode represents a node in a linked list
 * @param <T> the type of elements held in this collection
 */
public class LinearNode<T> {

    /**
     * A reference to the next node in the list
     */
    private LinearNode<T> next;

    /**
     *  The element stored in this node
     */
    private T element;

    /**
     * Creates an empty node
     */
    public LinearNode() {
        next = null;
        element = null;
    }

    /**
     * Creates a node storing the specified element
     * @param element  the element to be stored within the new node
     */
    public LinearNode(T element) {
        next = null;
        this.element = element;
    }

    /**
     * Returns the node that follows this one
     * @return the node that follows the current one
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one
     * @param next the node to be set as the next one
     */
    public void setNext(LinearNode<T> next) {
        this.next = next;
    }

    /**
     * Returns the element stored in this node
     * @return the element stored in this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node
     * @param element the element to be stored in this node
     */
    public void setElement(T element) {
        this.element = element;
    }
}
