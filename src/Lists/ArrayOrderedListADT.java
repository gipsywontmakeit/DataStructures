package Lists;

/**
 * ArrayOrderedListADT defines the interface to an ordered list collection
 * @param <T> the type of elements held in this collection
 */
public interface ArrayOrderedListADT<T> extends ListADT<T> {
/**
     * Adds the specified element to this list at the proper location
     * @param element the element to be added to this list
     */
    public void add(T element);

}
