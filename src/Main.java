import LinkedList.BasicLinkedList;
import Lists.ArrayOrderedList;
import Lists.LinkedList;
import Lists.OrderedList;
import Queue.CircularArrayQueue;
import Queue.LinkedQueue;
import Stack.ArrayStack;
import Stack.LinkedStack;
import demos.ArrayPostFix;

import java.util.Iterator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BasicLinkedList<Integer> linkedList = new BasicLinkedList<Integer>();
        //DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        CircularArrayQueue<String> circularArrayQueue = new CircularArrayQueue<>(3);
        OrderedList<Integer> orderedList = new OrderedList<>();
        ArrayOrderedList<Integer> arrayOrderedList = new ArrayOrderedList<>();

        System.out.println("Linked List: ");
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove();
        linkedList.printList();

        System.out.println("\n\nDoubly Linked List: ");
        //doublyLinkedList.add(1);
        //doublyLinkedList.add(2);
        //doublyLinkedList.add(3);
        //doublyLinkedList.printList();

        System.out.println("\n\nArray Stack: ");
        arrayStack.push(15);
        arrayStack.push(12);
        arrayStack.push(33);
        arrayStack.push(10);
        arrayStack.pop();
        System.out.println("Size: " + arrayStack.size());
        System.out.println("Peek: " + arrayStack.peek());
        arrayStack.toString();
        System.out.println("isEmpty: " + arrayStack.isEmpty());

        System.out.println("\nLinked Stack: ");
        linkedStack.push(11);
        linkedStack.push(213);
        linkedStack.push(92);
        linkedStack.push(34);
        linkedStack.push(8);
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.toString();
        System.out.println("Peek: " + linkedStack.peek());
        System.out.println("isEmpty: " + linkedStack.isEmpty());
        System.out.println("Size: " + linkedStack.size());

        System.out.println("\nPostfix Expression with Array Stack: ");
        String postFixExpression = "5 2 5 * + 9 -";
        int result = ArrayPostFix.evaluatePostfix(postFixExpression);
        System.out.println("\nResult: " + result);

        System.out.println("\nPostfix Expression with Linked Stack: ");
        String postFixExpression2 = "5 2 5 * + 9 -";
        int result2 = ArrayPostFix.evaluatePostfix(postFixExpression2);
        System.out.println("\nResult: " + result2);

        System.out.println("\nLinked Queue: ");
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(4);
        linkedQueue.enqueue(5);
        linkedQueue.dequeue();
        linkedQueue.toString();
        System.out.println("\nFirst: " + linkedQueue.first());
        System.out.println("isEmpty: " + linkedQueue.isEmpty());
        System.out.println("Size: " + linkedQueue.size());

        System.out.println("\nCircular Array Queue");
        circularArrayQueue.enqueue("Joe");
        circularArrayQueue.enqueue("Louis");
        circularArrayQueue.enqueue("Anna");
        circularArrayQueue.dequeue();
        circularArrayQueue.toString();
        System.out.println("\nFirst: " + circularArrayQueue.first());
        System.out.println("isEmpty: " + circularArrayQueue.isEmpty());
        System.out.println("Size: " + circularArrayQueue.size());

        System.out.println("\nOrdered List");
        orderedList.add(5);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.add(1);
        Iterator<Integer> iterator = orderedList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }

        System.out.println("\nArray Ordered List");
        arrayOrderedList.add(5);
        arrayOrderedList.add(2);
        arrayOrderedList.add(3);
        arrayOrderedList.add(1);
        Iterator<Integer> iterator2 = arrayOrderedList.iterator();
        while(iterator2.hasNext()) {
            System.out.println(iterator2.next() + " ");
        }




    }
}