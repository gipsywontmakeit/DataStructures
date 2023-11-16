package Lists;

import exceptions.ElementNotFoundException;

/**
 * ArrayUnorderedList represents an array implementation of an unordered list.
 * @param <T> the type of elements held in this collection
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements ArrayUnorderedListADT<T> {

/**
     * Creates an empty list using the default capacity.
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     * Adds the specified element to the front of this list.
     * @param element the element to be added to the front of this list
     */
    @Override
    public void addToFront(T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        if(isEmpty()) {
            list[count++] = element;
            return;
        }
        for (int i = count; i > 0; i--) {
            list[i] = list[i - 1];
        }
        list[0] = element;
        count++;
        modCount++;
    }

    /**
     * Adds the specified element to the rear of this list.
     * @param element the element to be added to the rear of this list
     */
    @Override
    public void addToRear(T element) {
        if (size() == list.length) {
            expandCapacity();
        }
        list[count++] = element;
        modCount++;
    }

    /**
     * Adds the specified element after the specified target element.
     * @param element the element to be added after the target
     * @param target the target is the item that the element will be added after
     */
    @Override
    public void addAfter(T element, T target) {
        if (size() == list.length) {
            expandCapacity();
        }

        int scan = 0;
        while (scan < count && !target.equals(list[scan])) {
            scan++;
        }

        if (scan == count) {
            throw new ElementNotFoundException("The element was not found in the list.");
        }

        scan++;
        for (int shift = count; shift > scan; shift--) {
            list[shift] = list[shift - 1];
        }

        list[scan] = element;
        count++;
        modCount++;


    }
}
