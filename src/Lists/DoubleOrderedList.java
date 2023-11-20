package Lists;

/**
 * DoubleOrderedList represents a double linked implementation of an ordered list.
 * @param <T> the type of elements held in this collection
 */
public class DoubleOrderedList<T> extends DoubleLinkedList<T> implements DoubleOrderedListADT<T>{

    /**
     * The method adds the specified element to this list at the proper location
     * @param element the element to be added to this list
     */
    @Override
    public void add(T element) {
        if (!(element instanceof Comparable)) {
            throw new RuntimeException("Not comparable");
        }

        DoubleNode<T> newNode = new DoubleNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            front = rear = newNode;
        } else if (comparableElement.compareTo(front.getElement()) < 0) {
            newNode.setNext(front);
            front.setPrevious(newNode);
            front = newNode;
        } else {
            DoubleNode<T> current = front;

            while (current.getNext() != null && comparableElement.compareTo(current.getNext().getElement()) > 0) {
                current = current.getNext();
            }

            if (current == front && comparableElement.compareTo(current.getElement()) < 0) {
                newNode.setNext(current);
                current.setPrevious(newNode);
                front = newNode;
            } else {
                newNode.setNext(current.getNext());
                if (current.getNext() != null) {
                    current.getNext().setPrevious(newNode);
                } else {
                    rear = newNode;
                }
                newNode.setPrevious(current);
                current.setNext(newNode);
            }
        }

        count++;
        modCount++;
    }

}
