package LinkedList;

import exceptions.EmptyCollectionException;

public class BasicLinkedList<T> {

    private int count;
    private Node<T> head,tail;

    public BasicLinkedList() {
        this.count = 0;
        head = tail = null;
    }

    public Node<T> add(T data) {
        Node<T> temp = new Node<T>(data);

        if(head == null) {
            head = tail = temp;
            count++;
            return head;
        }

        temp.setNext(head);
        head = temp;
        count++;

        return head;
    }

    public Node<T> remove() {
        if(head == null) {
            throw new EmptyCollectionException("Empty list");
        }
        return head = head.getNext();
    }

    public void printList() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
    }
}
