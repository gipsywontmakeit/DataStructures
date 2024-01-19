package tester.demos;

import Lists.OrderedList;

public class TestRecursion {
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Recursion.printListRecursively(list, list.front);
    }
}
