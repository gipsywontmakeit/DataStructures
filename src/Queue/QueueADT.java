package Queue;

/**
 * QueueADT defines the interface to a queue collection
 */
public interface QueueADT<T> {

        /**
        * Adds one element to the rear of the queue
        * @param element the element to be added to the rear of the queue
        */
        public void enqueue(T element);

        /**
        * Removes and returns the element at the front of the queue
        * @return the element at the front of the queue
        */
        public T dequeue();

        /**
        * Returns without removing the element at the front of the queue
        * @return the first element in the queue
        */
        public T first();

        /**
        * Returns true if the queue contains no elements
        * @return true if the queue is empty
        */
        public boolean isEmpty();

        /**
        * Returns the number of elements in the queue
        * @return the number of elements in the queue
        */
        public int size();

        /**
        * Returns a string representation of the queue
        * @return a string representation of the queue
        */
        @Override
        public String toString();
}
