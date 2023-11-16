package tester;

import Lists.DoubleOrderedList;

public class DoubleOrderedListDemo {
    public static void main(String[] args) {
        DoubleOrderedList<Integer> list = new DoubleOrderedList<>();

        list.add(3);
        list.add(1);
        list.add(7);
        list.add(5);
        list.add(4);
        System.out.println(list);
        System.out.println("IsEmpty : " + list.isEmpty());
        System.out.println("Size : " + list.size());
        System.out.println("Contains 3 : " + list.contains(3));
        System.out.println("Contains 2 : " + list.contains(2));
        System.out.println("First : " + list.first());
        System.out.println("Last : " + list.last());
        System.out.println("Remove first : " + list.removeFirst());
        System.out.println("Remove last : " + list.removeLast());
        System.out.println("Remove 3 : " + list.remove(3));
        System.out.println(list);

    }
}
