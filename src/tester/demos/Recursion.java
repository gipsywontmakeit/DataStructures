package tester.demos;

import Lists.LinearNode;
import Lists.LinkedList;
import Lists.OrderedList;

public class Recursion<T> extends LinkedList<T>{

        public static <T> void printListRecursively(OrderedList<T> list, LinearNode<T> node) {
           if(node != null) {
                System.out.print(node.getElement() + " ");
                printListRecursively(list, node.getNext());
           }
        }
}


