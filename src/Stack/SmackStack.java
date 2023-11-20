package Stack;

/**
 * SmackStack temporarlily reverses the order of the stack, removes
 * the top element, and then restores the original order of the stack
 * again.
 * @param <T> the type of elements held in this collection
 */
public class SmackStack<T> extends ArrayStack<T> implements SmackStackADT<T> {

    /**
     * Removes and returns the top element.
     * @return the top element
     */
    @Override
    public T smack() {
        ArrayStack<T> innerStack = new ArrayStack<>();

        while(!isEmpty()) {
            innerStack.push(pop());
        }

        T removed = innerStack.pop();

        while(!innerStack.isEmpty()) {
            push(innerStack.pop());
        }

        return removed;
    }
}
