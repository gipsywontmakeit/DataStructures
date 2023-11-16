package Queue;

import exceptions.EmptyCollectionException;

/**
 * LinkedQueue represents a linked implementation of a queue
 */
public class LinkedQueue<T> implements QueueADT<T> {
    /**
     * The number of elements in the queue
     */
    private int count;

    /**
     * A reference to the front of the queue
     */
    private LinearNode<T> front;

    /**
     * A reference to the rear of the queue
     */
    private LinearNode<T> rear;

    /**
     * Creates an empty queue
     */
    public LinkedQueue() {
        this.count = 0;
        this.front = null;
        this.rear = null;
    }


    /**
     * Adds one element to the rear of the queue
     * @param element the element to be added to the rear of the queue
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> temp = new LinearNode<>(element);
        if(isEmpty()) {
            front = temp;
        } else {
            rear.setNext(temp);
        }
        rear = temp;
        count++;

    }

    /**
     * Removes and returns the element at the front of the queue
     * @return the element at the front of the queue
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }
        T result = front.getElement();
        front = front.getNext();
        count--;

        return result;
    }

    /**
     * Returns without removing the element at the front of the queue
     * @return the first element in the queue
     */
    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }
        return front.getElement();
    }

    /**
     * Returns true if the queue contains no elements
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in the queue
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of the queue
     * @return a string representation of the queue
     */
    @Override
    public String toString() {
        String result = "";
        LinearNode<T> current = front;

        while (current != null)
        {
            System.out.print((current.getElement()) + " ");
            current = current.getNext();
        }

        return " ";
    }

}
