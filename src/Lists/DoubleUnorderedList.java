package Lists;

import exceptions.ElementNotFoundException;

/**
 * DoubleOrderedListADT defines the interface to a double
 * linked list collection that maintains its elements in
 * ascending order.
 * @param <T> the class of objects stored in the list
 */
public class DoubleUnorderedList<T> extends DoubleLinkedList<T> implements DoubleUnorderedListADT<T>{

    /**
     * Creates an empty list.
     */
    public DoubleUnorderedList() {
        super();
    }

    /**
     * Adds the specified element to the front of this list.
     * @param element the element to be added to the front of the list
     */
    @Override
    public void addToFront(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if (isEmpty()) {
            front = rear = newNode;
            count++;
            return;
        }

        front.setPrevious(newNode);
        newNode.setNext(front);
        front = newNode;
        count++;
        modCount++;
    }

    /**
     * Adds the specified element to the rear of this list.
     * @param element the element to be added to the rear of the list
     */
    @Override
    public void addToRear(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if (isEmpty()) {
            front = rear = newNode;
            count++;
            return;
        }

        newNode.setPrevious(rear);
        rear.setNext(newNode);
        rear = newNode;
        count++;
        modCount++;
    }

    /**
     * Adds the specified element after the specified target element.
     * Throws an ElementNotFoundException if the target is not found.
     * @param element the element to be added after the target element
     * @param target  the target that the element is to be added after
     */
    @Override
    public void addAfter(T element, T target) {
        DoubleNode<T> current = front;
        boolean found = false;
        while (current != null && !found) {
            if (current.getElement().equals(target)) {
                found = true;
            } else {
                current = current.getNext();
            }
        }
        if (!found) {
            throw new ElementNotFoundException("The element was not found");
        }
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if (current == rear) {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear = newNode;
        } else {
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            current.getNext().setPrevious(newNode);
            current.setNext(newNode);
        }
        count++;
        modCount++;
    }
}
