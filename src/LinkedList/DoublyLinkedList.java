package LinkedList;

public class DoublyLinkedList<T> {

    private Node<T> head, tail;
    private Node<T> next;

    private Node<T> previous;

    private int count;
    public DoublyLinkedList() {
        this.count = 0;
        head = tail = null;
    }

    public Node<T> add(T data) {
        Node<T> temp = new Node<>(data);

        if(head == null) {
            head = tail = temp;
            count++;
            return head;
        }

        temp.setNext(head);
        head.setPrevious(temp);
        head = temp;
        count++;

        return head;
    }

    /*
    public Node<T> remove() {
        if(head == null) {
            throw new EmptyCollectionException("Empty list");
        }
        
    }
    */

    public void printList() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
    }
}
