package tester.demos;

import Trees.*;
import Trees.Heaps.HeapADT;
import Trees.Heaps.LinkedHeap;

import java.util.Iterator;

public class Trees {
    public static void main(String[] args) {
        BinarySearchTreeADT<String> tree = new LinkedBinarySearchTree<>();

        tree.addElement("A");
        tree.addElement("B");
        tree.addElement("C");
        tree.addElement("D");
        tree.addElement("E");

        Iterator<String> levelOrder = tree.iteratorLevelOrder();
        System.out.println("Level order: ");
        while(levelOrder.hasNext()) {
            System.out.println(levelOrder.next());
        }
        System.out.println("-----");
        Iterator<String> preOrder = tree.iteratorPreOrder();
        System.out.println("Pre order: ");
        while(preOrder.hasNext()) {
            System.out.println(preOrder.next());
        }
        System.out.println("-----");
        Iterator<String> inOrder = tree.iteratorInOrder();
        System.out.println("In order: ");
        while(inOrder.hasNext()) {
            System.out.println(inOrder.next());
        }
        System.out.println("-----");
        Iterator<String> postOrder = tree.iteratorPostOrder();
        System.out.println("Post order: ");
        while(postOrder.hasNext()) {
            System.out.println(postOrder.next());
        }

        System.out.println("-----");
        System.out.println("Array");

        BinarySearchTreeADT<String> tree2 = new ArrayBinarySearchTree<>();

        tree2.addElement("A");
        tree2.addElement("B");
        tree2.addElement("C");
        tree2.addElement("D");
        tree2.addElement("E");

        Iterator<String> levelOrder2 = tree2.iteratorLevelOrder();
        System.out.println("Level order: ");
        while(levelOrder2.hasNext()) {
            System.out.println(levelOrder2.next());
        }
        System.out.println("-----");
        Iterator<String> preOrder2 = tree2.iteratorPreOrder();
        System.out.println("Pre order: ");
        while(preOrder2.hasNext()) {
            System.out.println(preOrder2.next());
        }
        System.out.println("-----");
        Iterator<String> inOrder2 = tree2.iteratorInOrder();
        System.out.println("In order: ");
        while(inOrder2.hasNext()) {
            System.out.println(inOrder2.next());
        }
        System.out.println("-----");
        Iterator<String> postOrder2 = tree2.iteratorPostOrder();
        System.out.println("Post order: ");
        while(postOrder2.hasNext()) {
            System.out.println(postOrder2.next());
        }

        HeapADT<String> heap = new LinkedHeap<>();
        System.out.println("Heaps: ");
        heap.addElement("A");
        heap.addElement("B");
        heap.addElement("C");
        heap.addElement("D");
        heap.addElement("E");

        Iterator<String> levelorder = heap.iteratorLevelOrder();
        while(levelorder.hasNext()) {
            System.out.println(levelorder.next());
        }
        System.out.println("-----");
        Iterator<String> inorder = heap.iteratorInOrder();
        while(inorder.hasNext()) {
            System.out.println(inorder.next());
        }
        System.out.println("-----");
        Iterator<String> preorder = heap.iteratorPreOrder();
        while(preorder.hasNext()) {
            System.out.println(preorder.next());
        }
        System.out.println("-----");
        Iterator<String> postorder = heap.iteratorPostOrder();
        while(postorder.hasNext()) {
            System.out.println(postorder.next());
        }




    }
}
