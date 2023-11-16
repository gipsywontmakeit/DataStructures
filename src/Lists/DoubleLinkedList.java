package Lists;

import exceptions.EmptyCollectionException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * DoubleLinkedList represents a linked implementation of a list.
 *
 * @param <T> the type of elements held in this collection
 */
public abstract class DoubleLinkedList<T> implements ListADT<T> {

    /**
     * The number of elements in this list.
     */
    int count;

    /**
     * Reference to the first element of this list.
     */
    DoubleNode<T> front;

    /**
     * Reference to the last element of this list.
     */
    DoubleNode<T> rear;

    /**
     * The number of modifications to this list.
     */
    protected int modCount;

    /**
     * Creates an empty list using the default capacity.
     */
    public DoubleLinkedList() {
        modCount = 0;
        front = null;
        rear = null;
    }

    private class DoubleLinkedIterator implements Iterator<T> {

        /**
         * The previous node in the iteration.
         */
        private DoubleNode<T> previous;

        /**
         * The current position in this iterator.
         */
        private DoubleNode<T> current;

        /**
         * The number of elements in the collection
         */
        private int expectedModCount;

        /**
         * Flag to indicate whether it's okay to remove
         */
        private boolean okToRemove;

        /**
         * Default constructor
         * @param modCount the number of modifications to the collection
         */
        public DoubleLinkedIterator(int modCount) {
            this.current = front;
            this.previous = null;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         * @return true if this iterator has at least one more element
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         * @return the next element in the iteration
         * @throws java.util.NoSuchElementException if a no such element exception occurs
         */
        @Override
        public T next() {
            if(!hasNext()) {
                throw new EmptyCollectionException("The list is empty");
            }
            okToRemove = true;
            T element = current.getElement();
            previous = current;
            current = current.getNext();
            return element;
        }

        /**
         * Removes from the underlying collection the last element returned by this iterator
         * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been called after the last call to the next method
         */
        @Override
        public void remove() {
            if(!okToRemove) {
                throw new IllegalStateException("Illegal state");
            }

            if(expectedModCount != DoubleLinkedList.this.modCount) {
                throw new ConcurrentModificationException("The list has been modified");
            }

            DoubleLinkedList.this.remove(previous.getElement());
            okToRemove = false;
            expectedModCount++;
        }
    }

    /**
     * Removes and returns the first element from this list.
     * @return the first element from this list
     * @throws EmptyCollectionException if the list is empty
     */
    @Override
    public T removeFirst() {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        T removed = front.getElement();
        front.setPrevious(null);
        front = front.getNext();
        count--;
        modCount++;
        return removed;
    }

    /**
     * Removes and returns the last element from this list.
     * @return the last element from this list
     */
    @Override
    public T removeLast() {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        T removed = rear.getElement();
        rear = rear.getPrevious();
        rear.setNext(null);
        count--;
        modCount++;
        return removed;
    }

    /**
     * Removes and returns the specified element from this list.
     * @param element the element to be removed from the list
     * @return the element that was removed from the list
     */
    @Override
    public T remove(T element) {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        if(front.getElement() == element) {
            return removeFirst();
        }

        if(rear.getElement() == element) {
            return removeLast();
        }

        DoubleNode<T> current = front;
        while(current != null) {
            if(current.getElement() == element) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                count--;
                modCount++;
                return current.getElement();
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Returns a reference to the first element in this list.
     * @return a reference to the first element in this list
     */
    @Override
    public T first() {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        return front.getElement();
    }

    /**
     * Returns a reference to the last element in this list.
     * @return a reference to the last element in this list
     */
    @Override
    public T last() {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        return rear.getElement();
    }

    /**
     * Returns true if this list contains the specified target element.
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }
        DoubleNode<T> current = front;
        while(current != null) {
            if(current.getElement() == target) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in this list.
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns an iterator for the elements in this list.
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedIterator(modCount);
    }

    /**
     * Returns a string representation of this list.
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        DoubleNode<T> current = front;

        while(current != null) {
            result.append(current.getElement()).append(" ");
            current = current.getNext();
        }
        return result.toString().trim();
    }
}
