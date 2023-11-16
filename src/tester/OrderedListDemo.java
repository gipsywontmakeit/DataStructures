package tester;

import Lists.OrderedList;

import java.util.Iterator;

public class OrderedListDemo {
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<>();
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(6);
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

        System.out.println("Iterator");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }
}
