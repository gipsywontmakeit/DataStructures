package Lists;

/**
 * DoubleOrderedListADT defines the interface to a double
 * linked list collection that maintains its elements in
 * ascending order.
 * @param <T> the class of objects stored in the list
 */
public interface DoubleOrderedListADT<T> extends ListADT<T> {
    /**
     * Adds the specified element to this list at the proper location
     * @param element the element to be added to this list
     */
    public void add(T element);
}
