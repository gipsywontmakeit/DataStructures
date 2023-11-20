package tester;

import Stack.SmackStack;

public class SmackStackDemo {
    public static void main(String[] args) {
        SmackStack<Integer> stack = new SmackStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        stack.smack();
        System.out.println(stack);
    }
}
