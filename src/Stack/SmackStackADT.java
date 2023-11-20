package Stack;

/**
 * SmackStackADT represents the interface to a stack collection.
 * @param <T> the type of elements held in this collection
 */
public interface SmackStackADT<T> extends StackADT<T> {

    /**
     * Returns the top element without removing it.
     * @return the top element
     */
    public T smack();
}
