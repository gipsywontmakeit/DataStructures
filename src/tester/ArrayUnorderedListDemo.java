package tester;

import Lists.ArrayUnorderedList;

import java.util.Iterator;

public class ArrayUnorderedListDemo {
    public static void main(String[] args) {
        ArrayUnorderedList<Integer> list = new ArrayUnorderedList<>();
        list.addToFront(7);
        list.addToFront(2);
        list.addToFront(5);
        list.addToFront(1);
        list.addToFront(6);
        list.addToFront(3);
        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println("isEmpty: " + list.isEmpty());
        System.out.println("Contains 5: " + list.contains(5));
        System.out.println("Contains 10: " + list.contains(10));
        System.out.println("Remove 5: " + list.remove(5));
        System.out.println(list);
        System.out.println("Last: " + list.last());
        System.out.println("First: " + list.first());
        System.out.println("Remove first: " + list.removeFirst());
        System.out.println("Remove last: " + list.removeLast());
        System.out.println(list);
        list.addToRear(10);
        list.addToRear(11);
        System.out.println(list);
        list.addAfter(12, 10);
        list.addAfter(6,6);
        System.out.println(list);

        System.out.println("Iterator: ");
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
