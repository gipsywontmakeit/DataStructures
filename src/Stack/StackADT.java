package Stack;

/**
 * StackADT defines the interface to a stack collection
 * @param <T> the type of elements in the stack
 */
public interface StackADT<T> {

    /**
     * Adds one element to the top of the stack
     * @param element the element to be added to the stack
     */
    public void push(T element);

    /**
     * Removes and returns the top element from the stack
     * @return the element removed from the stack
     */
    public T pop();

    /**
     * Returns without removing the top element of the stack
     * @return the element on top of the stack
     */
    public T peek();

    /**
     * Returns true if the stack contains no elements
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    public int size();

    /**
     * Returns a string representation of the stack
     * @return a string representation of the stack
     */
    @Override
    public String toString();

}
