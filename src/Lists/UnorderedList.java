package Lists;

public class UnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T>{
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
