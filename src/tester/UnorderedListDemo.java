package tester;

import Lists.UnorderedList;

public class UnorderedListDemo {
    public static void main(String[] args) {
        UnorderedList<Integer> unorderedList = new UnorderedList<>();

        unorderedList.addToFront(1);
        unorderedList.addToFront(2);
        unorderedList.addToFront(3);
        unorderedList.addToFront(4);
        unorderedList.addToRear(5);
        unorderedList.addAfter(6, 3);
        System.out.println(unorderedList);
    }
}
