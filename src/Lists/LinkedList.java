package Lists;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import exceptions.NoSuchElementException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * LinkedList represents a linked implementation of a list.
 *
 * @param <T> the type of elements held in this collection
 */
public abstract class LinkedList<T> implements ListADT<T> {

    /**
     * The number of elements in this list.
     */
    int count;

    /**
     * Reference to the first element of this list.
     */
    LinearNode<T> front;

    /**
     * Reference to the last element of this list.
     */
    LinearNode<T> rear;

    /**
     * The number of modifications to this list.
     */
    protected int modCount;

    /**
     * Creates an empty list using the default capacity.
     */
    protected LinkedList<T> list;


    /**
     * Creates an empty list.
     */
    public LinkedList() {
        count = 0;
        front = null;
        rear = null;
    }

    /**
     * LinkedIterator represents an iterator for a linked list of linear nodes.
     */
    private class LinkedIterator implements Iterator<T> {

        /**
         * The previous node in the iteration.
         */
        private LinearNode<T> previous;

        /**
         * The current position in this iterator.
         */
        private LinearNode<T> current;

        /**
         * A flag indicating if it is okay to remove the element.
         */
        private boolean okToRemove;

        /**
         * The expected mod count of the list.
         */
        private int expectedModCount;

        public LinkedIterator(int modCount) {
            this.expectedModCount = modCount;
            this.current = front;
            this.previous = null;
            this.okToRemove = false;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         * @return true if this iterator has at least one more element to deliver
         * in the iteration
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

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

        @Override
        public void remove() {
            if(expectedModCount != modCount) {
                throw new ConcurrentModificationException("The list has been modified");
            }
            if(!okToRemove) {
                throw new IllegalStateException("Illegal state");
            }
            list.remove(previous.getElement());
            okToRemove = false;
        }
    }

    /**
     * Removes and returns the first element from this list.
     * @return the first element from this list
     * @throws EmptyCollectionException if the list is empty
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("LinkedList");
        }
        LinearNode<T> result = front;
        front = front.getNext();
        count--;
        return result.getElement();

    }

    /**
     * Removes and returns the last element from this list.
     * @return the last element from this list
     * @throws EmptyCollectionException if the list is empty
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("LinkedList");
        }
        LinearNode<T> previous = null;
        LinearNode<T> current = front;

        while(current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        LinearNode<T> result = rear;
        rear = previous;
        if(rear == null) {
            front = null;
        } else {
            rear.setNext(null);
        }
        count--;
        return result.getElement();
    }

    /**
     * Removes and returns the specified element from this list.
     * @param element the element to be removed from the list
     * @return the removed element
     * @throws EmptyCollectionException if the list is empty
     * @throws ElementNotFoundException if the specified element is not found
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        boolean found = false;

        LinearNode<T> previous = null;
        LinearNode<T> current = front;

        while(current != null && !found) {
            if(element.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if(!found) {
            throw new ElementNotFoundException("The element was not found");
        }

        if(size() == 1) {
            front = rear = null;
        } else if(current.equals(front)) {
            front = current.getNext();
        } else if(current.equals(rear)) {
            rear = previous;
            rear.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        count--;
        return current.getElement();
    }

    /**
     * Returns a reference to the first element in this list.
     * @return a reference to the first element in this list
     * @throws EmptyCollectionException if the list is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }
        return front.getElement();
    }

    /**
     * Returns a reference to the last element in this list.
     * @return a reference to the last element in this list
     * @throws EmptyCollectionException if the list is empty
     */
    @Override
    public T last() throws EmptyCollectionException
    {
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
    public boolean contains(T target) throws EmptyCollectionException {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        boolean found = false;

        LinearNode<T> current = front;

        while(current != null && !found) {
            if(target.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }

        return found;
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

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator(modCount);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinearNode<T> temp = front;

        while (temp != null) {
            result.append(temp.getElement()).append(" ");
            temp = temp.getNext();
        }

        return result.toString().trim();
    }

}
