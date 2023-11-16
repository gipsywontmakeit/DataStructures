package Lists;

import exceptions.EmptyCollectionException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * ArrayList represents an array implementation of a list.
 * @param <T> the type of elements held in this collection
 */
public abstract class ArrayList<T> implements ListADT<T> {

    /**
     * The element is not in the list.
     */
    private final int NOT_FOUND = -1;


    /**
     * The initial capacity of the list.
     */
    protected final int DEFAULT_CAPACITY = 100;

    /**
     * The number of modifications in this list.
     */
    protected int modCount;

    /**
     * The number of elements in this list
     * and the index of the next available position in this list.
     */
     protected int count;

    /**
     * The underlying array of this list.
     */
    protected T[] list;

    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayList() {
        modCount = 0;
        list = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty list using the specified capacity.
     * @param initialCapacity the integer value of the size of the array list
     */
    public ArrayList(int initialCapacity) {
        modCount = 0;
        list = (T[]) (new Object[initialCapacity]);
    }


    /**
     * Creates a new array to store the contents of this list with
     * twice the capacity of the old one.
     */
    protected void expandCapacity() {
        T[] larger = (T[]) (new Object[list.length * 2]);

        for (int scan = 0; scan < list.length; scan++) {
            larger[scan] = list[scan];
        }

        list = larger;
    }

    /**
     * Returns the index of the specified element.
     * @param element the element to be found
     * @return the integer index of the element, or -1 if it is not found
     */
    protected int find(T element) {
        int scan = 0;
        int result = NOT_FOUND;
        boolean found = false;

        if (!isEmpty()) {
            while (!found && scan < count) {
                if (element.equals(list[scan])) {
                    found = true;
                } else {
                    scan++;
                }
            }
        }

        if (found) {
            result = scan;
        }

        return result;
    }

    /**
     * ArrayListIterator represents an iterator for an array list of linear nodes.
     */
    private class ArrayListIterator implements Iterator<T> {

        /**
         * The current position in this iterator.
         */
        private int current;

        /**
         * The expected number of modifications to the list.
         */
        private int expectedModCount;

        /**
         * A flag indicating whether it's okay to remove the current element.
         */
        private boolean okToRemove;

        /**
         * Sets up this iterator using the specified mod count.
         * @param modCount the current modification count for the list
         */
        public ArrayListIterator(int modCount) {
            this.expectedModCount = modCount;
            this.current = 0;
            this.okToRemove = false;
        }

        /**
         * Returns true if this iterator has at least one more element to deliver
         * in the iteration.
         * @return true if this iterator has at least one more element to deliver
         * in the iteration
         */
        @Override
        public boolean hasNext() {
            return current < count;
        }

        /**
         * Returns the next element in the iteration. If there are no more elements
         * in this iteration, a NoSuchElementException is thrown.
         * @return the next element in the iteration
         * @throws ConcurrentModificationException if the collection has changed
         * during the iteration
         * @throws IllegalStateException if no more elements exist in the collection
         */
        @Override
        public T next() {
            if(expectedModCount != ArrayList.this.modCount) {
                throw new ConcurrentModificationException();
            }

            okToRemove = true;
            current++;
            return list[current - 1];
        }

        /**
         * Removes the last element returned by this iterator.
         * @throws ConcurrentModificationException if the collection has changed
         * during the iteration
         * @throws IllegalStateException if the next method has not yet been called,
         * or the remove method has already been called after the last call to the
         * next method
         */
        @Override
        public void remove() {
            if(expectedModCount != ArrayList.this.modCount) {
                throw new ConcurrentModificationException();
            }

            if(!okToRemove) {
                throw new IllegalStateException();
            }

            ArrayList.this.remove(list[current - 1]);
            expectedModCount++;
            okToRemove = false;
            current--;
        }
    }

    /**
     * Removes and returns the last element in this list.
     * Shifts all subsequent elements to the left.
     * @return the last element in the list
     * @throws EmptyCollectionException if the element is not in the list
     */
    @Override
    public T removeFirst() {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }
        T removed = list[0];
        count--;
        for(int i = 0; i < count; i++) {
            list[i] = list[i + 1];
        }
        list[count] = null;
        return removed;
    }

    /**
     * Removes and returns the last element in this list.
     * Shifts all subsequent elements to the left.
     * @return the last element in the list
     * @throws EmptyCollectionException if the element is not in the list
     */
    @Override
    public T removeLast() {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }
        T removed;
        count--;
        removed = list[count];
        list[count] = null;

        return removed;
    }

    /**
     * Removes and returns the specified element.
     * Shifts all subsequent elements to the left.
     * @param element the element to be removed and returned
     * @return the removed element
     * @throws EmptyCollectionException if the element is not in the list
     */
    @Override
    public T remove(T element) {
        T removed;
        int index = find(element);

        if(index == NOT_FOUND) {
            throw new EmptyCollectionException("The element is not in the list");
        }

        removed = list[index];
        count--;
        for(int i = index; i < count; i++) {
            list[i] = list[i + 1];
        }
        list[count] = null;
        return removed;
    }

    /**
     * Returns a reference to the element at the front of this list.
     * The element is not removed from the list.  Throws an
     * EmptyCollectionException if the list is empty.
     * @return a reference to the first element in the list
     * @throws EmptyCollectionException if the list is empty
     */
    @Override
    public T first() {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }
        return list[0];
    }

    /**
     * Returns the last element in this list without removing it.
     * @return the last element in the list
     * @throws EmptyCollectionException if the element is not in the list
     */
    @Override
    public T last() {
        if(isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }
        return list[count - 1];
    }

    /**
     * Returns true if this list contains the specified element.
     * @param target the target element
     * @return true if the target is in the list, false otherwise
     */
    @Override
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    /**
     * Returns true if this list is empty and false otherwise.
     * @return true if the list is empty and false if otherwise
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
     * Returns an iterator for the elements currently in this list.
     * @return an iterator for the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator(modCount);
    }

    /**
     * Returns a string representation of this list.
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int scan=0; scan < count; scan++)
            result.append(list[scan].toString()).append(" ");

        return result.toString();
    }
}

