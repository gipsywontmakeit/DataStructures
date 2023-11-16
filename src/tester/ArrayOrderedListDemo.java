package tester;

import Lists.ArrayOrderedList;

import java.util.Iterator;

public class ArrayOrderedListDemo {
    public static void main(String[] args) {
        ArrayOrderedList<Integer> list = new ArrayOrderedList<>();
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(3);
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
        System.out.println("Iterator: ");
        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }


    }
}
