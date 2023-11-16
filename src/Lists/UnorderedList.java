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

    }

    @Override
    public void addAfter(T element, T target) {

    }
}
