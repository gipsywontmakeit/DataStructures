package Lists;

public class OrderedList<T> extends LinkedList<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) {
        if (!(element instanceof Comparable)) {
            throw new RuntimeException("Not comparable");
        }

        LinearNode<T> newNode = new LinearNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            front = rear = newNode;
        } else if (comparableElement.compareTo(front.getElement()) < 0) {
            newNode.setNext(front);
            front = newNode;
        } else {
            LinearNode<T> current = front;

            while (current.getNext() != null && comparableElement.compareTo(current.getNext().getElement()) > 0) {
                current = current.getNext();
            }

            if (current == front && comparableElement.compareTo(current.getElement()) < 0) {
                newNode.setNext(current);
                front = newNode;
            } else {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                if (current == rear) {
                    rear = newNode;
                }
            }
        }

        count++;
        modCount++;
    }

}
