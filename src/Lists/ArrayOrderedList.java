package Lists;

/**
 * ArrayOrderedList represents an array implementation of an ordered list.
 * @param <T> the type of elements held in this collection
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements ArrayOrderedListADT<T> {

    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayOrderedList() {
        super();
    }

    /**
     * Creates an empty list using the specified capacity.
     * @param initialCapacity the integer value of the size of the array list
     */
    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Adds the specified element to this list at the proper location
     * @param element the element to be added to this list
     */
    @Override
    public void add(T element) {
        if (size() == list.length) {
            expandCapacity();
        }
        Comparable<T> comparableElement = (Comparable<T>) element;
        int scan = 0;
        while (scan < count && comparableElement.compareTo(list[scan]) > 0) {
            scan++;
        }
        for (int shift = count; shift > scan; shift--) {
            list[shift] = list[shift - 1];
        }
        list[scan] = element;
        count++;
        modCount++;
    }
}
