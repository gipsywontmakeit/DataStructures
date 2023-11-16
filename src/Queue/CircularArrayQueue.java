package Queue;

import Queue.QueueADT;
import exceptions.EmptyCollectionException;

/**
 * CircularArrayQueue represents an array implementation of a queue in which the
 * indexes for the front and rear of the queue circle back to 0 when they reach
 * the end of the array
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    /**
     * Default capacity of the queue
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * Current capacity of the queue
     */
    private T[] queue;

    /**
     * Front of the queue
     */
    private int front;

    /**
     * Rear of the queue
     */
    private int rear;

    /**
     * Number of elements in the queue
     */
    private int count;

    /**
     * Creates an empty queue using the default capacity
     */
    public CircularArrayQueue() {
        this.front = 0;
        this.rear = 0;
        this.queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates an empty queue using the default capacity
     * @param initialCapacity the initial size of the circular array queue
     */
    public CircularArrayQueue(int initialCapacity) {
        this.front = 0;
        this.rear = 0;
        this.queue = (T[]) new Object[initialCapacity];
    }

    /**
     * Creates an empty queue using the default capacity
     * @param element the element to be added to the rear of the queue
     */
    @Override
    public void enqueue(T element) {
        if(size() == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    /**
     * Removes and returns the element at the front of the queue
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }

        T result = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        count--;

        return result;
    }

    /**
     * Returns without removing the element at the front of the queue
     * @return the first element in the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }
        return queue[front];
    }

    /**
     * Returns true if the queue is empty
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
        int current = front;
        int elementsCount = 0;

        while (elementsCount < count) {
            System.out.print(queue[current] + " ");
            current = (current + 1) % queue.length;
            elementsCount++;
        }
        return " ";
    }

    /**
     * Creates a new array to store the contents of the queue with
     * twice the capacity of the old one
     */
    private void expandCapacity() {
        T[] temp = (T[]) new Object[queue.length * 2];

        for(int i = 0; i < queue.length; i++) {
            temp[i] = queue[front];
            front = (front + 1) % queue.length;
        }

        front = 0;
        rear = queue.length;
        queue = temp;
    }
}
