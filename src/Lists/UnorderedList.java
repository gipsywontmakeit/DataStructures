package Lists;

/**
 * UnorderedList represents a singly linked implementation of an unordered list.
 * @param <T> the type of elements held in this collection
 */
public class UnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T>{

    /**
     * Creates an empty list using the default capacity.
     * @param element the element to be added to the front of this list
     */
    @Override
    public void addToFront(T element) {
        LinearNode<T> node = new LinearNode<>(element);

        if(isEmpty()) {
            front = rear = node;
        } else {
            node.setNext(front);
            front = node;
        }
        count++;
        modCount++;
    }


    /**
     * Creates an empty list using the default capacity.
     * @param element the element to be added to the rear of this list
     */
    @Override
    public void addToRear(T element) {
        LinearNode<T> node = new LinearNode<>(element);

        if(isEmpty()) {
            front = rear = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
        count++;
        modCount++;
    }

    /**
     * Creates an empty list using the default capacity.
     * @param element the element to be added after the target
     * @param target the target is the item that the element will be added after
     */
    @Override
    public void addAfter(T element, T target) {
        LinearNode<T> node = new LinearNode<>(element);
        LinearNode<T> current = front;

        while(current != null && !current.getElement().equals(target)) {
            current = current.getNext();
        }

        if(current == null) {
            throw new RuntimeException("Element not found");
        }

        node.setNext(current.getNext());
        current.setNext(node);
        count++;
        modCount++;
    }
}
