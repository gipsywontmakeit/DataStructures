package Trees;

import Lists.ArrayUnorderedList;
import Queue.LinkedQueue;
import exceptions.ElementNotFoundException;

import java.util.Iterator;

/**
 * ArrayBinaryTree represents an array implementation of a binary tree
 * @param <T> the type of elements held in this collection
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    /**
     * The default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 50;

    /**
     * The number of elements in the tree
     */
    protected int count;

    /**
     * The tree
     */
    protected T[] tree;

    /**
     * Creates an empty binary tree
     */
    public ArrayBinaryTree() {
        count = 0;
        tree = (T[]) new Object[DEFAULT_CAPACITY];

    }

    /**
     * Creates a binary tree with the specified element as its root
     *
     * @param element the element that will become the root of the new binary tree
     */
    public ArrayBinaryTree(T element) {
        count = 1;
        tree = (T[]) new Object[DEFAULT_CAPACITY];
        tree[0] = element;
    }

    /**
     * Returns a reference to the root element
     *
     * @return a reference to the root
     */
    @Override
    public T getRoot() {
        return this.tree[0];
    }

    /**
     * Returns true if this binary tree is empty and false otherwise
     *
     * @return true if this binary tree is empty
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Returns the integer size of this tree
     *
     * @return the integer size of this tree
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Returns true if the binary tree contains an element that matches the specified element and false otherwise
     *
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    @Override
    public boolean contains(T targetElement) {
        try {
            return this.find(targetElement) != null;
        } catch (ElementNotFoundException e) {
            return false;
        }
    }

    /**
     * Returns a reference to the specified element if it is found in this binary tree. Throws an exception if the specified element is not found
     *
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified element
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        boolean found = false;
        T result = null;

        for (int i = 0; i < this.size(); i++) {
            if (targetElement.equals(this.tree[i])) {
                found = true;
                result = this.tree[i];
            }
        }

        if (!found) {
            throw new ElementNotFoundException("The element was not found in the tree");
        }

        return result;
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an overloaded, recursive inorder method that starts with the root
     *
     * @param node the node to be used as the root for this traversal
     * @param iter the iterator to use for the traversal
     */
    protected void inorder(int node, Iterator<T> iter) {
        if (node < this.size()) {
            this.inorder(node * 2 + 1, iter);
            iter.next();
            this.inorder(node * 2 + 2, iter);
        }
    }

    /**
     * Performs a preorder traversal on this binary tree by calling an overloaded, recursive preorder method that starts with the root
     *
     * @param node the node to be used as the root for this traversal
     * @param iter the iterator to use for the traversal
     */
    protected void preorder(int node, Iterator<T> iter) {
        if (node < this.size()) {
            iter.next();
            this.preorder(node * 2 + 1, iter);
            this.preorder(node * 2 + 2, iter);
        }
    }

    /**
     * Performs a postorder traversal on this binary tree by calling an overloaded, recursive postorder method that starts with the root
     *
     * @param node the node to be used as the root for this traversal
     * @param iter the iterator to use for the traversal
     */
    protected void postorder(int node, Iterator<T> iter) {
        if (node < this.size()) {
            this.postorder(node * 2 + 1, iter);
            this.postorder(node * 2 + 2, iter);
            iter.next();
        }
    }

    /**
     * Performs a levelorder traversal on this binary tree, using a queue
     *
     * @param node     the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void levelorder(int node, ArrayUnorderedList<T> tempList) {
        if (node < this.size() && this.tree[node] != null) {
            LinkedQueue<Integer> queue = new LinkedQueue<>();
            queue.enqueue(node);

            while (!queue.isEmpty()) {
                int current = queue.dequeue();
                tempList.addToRear(this.tree[current]);

                int leftChild = current * 2 + 1;
                int rightChild = current * 2 + 2; // Fix this line

                if (leftChild < this.size() && this.tree[leftChild] != null) {
                    queue.enqueue(leftChild);
                }

                if (rightChild < this.size() && this.tree[rightChild] != null) {
                    queue.enqueue(rightChild);
                }
            }
        }
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an overloaded, recursive inorder method that starts with the root
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        this.inorder(0, tempList.iterator());
        return tempList.iterator();
    }

    /**
     * Performs a preorder traversal on this binary tree by calling an overloaded, recursive preorder method that starts with the root
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        this.preorder(0, tempList.iterator());
        return tempList.iterator();
    }

    /**
     * Performs a postorder traversal on this binary tree by calling an overloaded, recursive postorder method that starts with the root
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        this.postorder(0, tempList.iterator());
        return tempList.iterator();
    }

    /**
     * Performs a levelorder traversal on this binary tree, using a queue
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        this.levelorder(0, tempList);
        return tempList.iterator();
    }

    protected void expandCapacity() {
        T[] temp = (T[]) new Object[tree.length * 2];
        for (int ct = 0; ct < tree.length; ct++)
            temp[ct] = tree[ct];
        tree = temp;

    }
}
