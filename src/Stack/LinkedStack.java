package Stack;

import exceptions.EmptyCollectionException;

/**
 * LinkedStack represents a linked implementation of a stack
 */
public class LinkedStack<T> implements StackADT<T> {

    /**
     * The number of elements in the stack
     */
    private int count;

    /**
     * A reference to the top of the stack
     */
    private LinearNode<T> top;

    /**
     * Creates an empty stack
     */
    public LinkedStack() {
        this.count = 0;
        this.top = null;
    }

    /**
     * Adds one element to the top of the stack
     * @param element the element to be added to the top of the stack
     */
    @Override
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<>(element);

        if(isEmpty()) {
            top = temp;
        } else {
            temp.setNext(top);
            top = temp;
        }
        count++;

    }

    /**
     * Removes and returns the element at the top of the stack
     * @return the element at the top of the stack
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("Stack is empty");
        }
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    /**
     * Returns without removing the element at the top of the stack
     * @return the element at the top of the stack
     */
    @Override
    public T peek() {
        return top.getElement();
    }

    /**
     * Returns true if the stack is empty
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of the stack
     * @return a string representation of the stack
     */
    @Override
    public String toString() {
        LinearNode<T> temp = top;

        while(temp != null) {
            System.out.println(temp.getElement() + " ");
            temp = temp.getNext();
        }
        return " ";
    }
}

