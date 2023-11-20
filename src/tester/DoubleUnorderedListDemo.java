package tester;

import Lists.DoubleUnorderedList;

import java.sql.SQLOutput;
import java.util.Iterator;

public class DoubleUnorderedListDemo {
    public static void main(String[] args) {
        DoubleUnorderedList<Integer> list = new DoubleUnorderedList<>();

        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);
        list.addToRear(5);
        list.addToRear(6);
        list.addToRear(7);
        list.addAfter(4, 3);
        list.addAfter(6, 5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
