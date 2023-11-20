package Stack;

import exceptions.EmptyCollectionException;

/**
 * Array stack represents an array implementation of a stack.
 */
public class ArrayStack<T> implements StackADT<T> {

    /**
     * The number of elements in the stack
     */
    private int top;

    /**
     * A reference to the top of the stack
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * A reference to the top of the stack
     */
    private T[] stack;

    /**
     * Creates an empty stack
     */
    public ArrayStack() {
        this.top = 0;
        this.stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates an empty stack
     */
    public ArrayStack(int initialCapacity) {
        this.top = 0;
        this.stack = (T[]) new Object[initialCapacity];
    }

    /**
     * Adds one element to the top of the stack
     * @param element the element to be added to the top of the stack
     */
    @Override
    public void push(T element) {
        if(size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
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
        top--;
        T result = stack[top];
        stack[top] = null;

        return result;
    }

    /**
     * Returns without removing the element at the top of the stack
     * @return the element at the top of the stack
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("Stack is empty");
        }
        return stack[top - 1];
    }

    /**
     * Returns true if the stack is empty
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return top;
    }

    /**
     * Returns a string representation of the stack
     * @return a string representation of the stack
     */
    @Override
    public String toString() {
        for(int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
        return "";

    }


    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one
     */
    private void expandCapacity() {
        T[] temp = (T[]) new Object[stack.length * 2];
        for(int i = 0; i < stack.length; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }
}
