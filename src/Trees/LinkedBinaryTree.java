package Trees;

import Queue.LinkedQueue;
import Queue.QueueADT;
import exceptions.ElementNotFoundException;

import java.util.Iterator;

import Lists.ArrayUnorderedList;
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    /**
     * The number of nodes in the tree
     */
    protected int count;

    /**
     * A reference to the root of this tree
     */
    protected BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree
     */
    public LinkedBinaryTree() {
        count = 0;
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root
     *
     * @param element the element that will become the root of the new binary tree
     */
    public LinkedBinaryTree(T element) {
        count = 1;
        root = new BinaryTreeNode<>(element);
    }

    /**
     * Returns a reference to the root element
     *
     * @return a reference to the root
     */
    @Override
    public T getRoot() {
        return this.root.element;
    }

    /**
     * Returns true if this binary tree is empty and false otherwise
     *
     * @return true if this binary tree is empty
     */
    @Override
    public boolean isEmpty() {
        return root == null;
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
        BinaryTreeNode<T> found = this.findAgain(targetElement, root);

        return found != null;
    }

    /**
     * Returns a reference to the specified element if it is found in this binary tree. Throws an exception if the specified element is not found
     *
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified element
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> found = this.findAgain(targetElement, root);

        if (found == null) {
            throw new ElementNotFoundException("The element was not found in the tree");
        }

        return found.element;
    }

    /**
     * Returns a reference to the specified element if it is found in this binary tree
     * Throws an exception if the specified element is not found
     * @param targetElement the element being sought in the tree
     * @param next the tree node to begin searching on
     * @return a reference to the specified element
     */
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> found = findAgain(targetElement, next.left);

        if (found == null) {
            found = findAgain(targetElement, next.right);
        }

        return found;
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an overloaded, recursive inorder method that starts with the root
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if(node == null) {
            return;
        } else {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }

    /**
     * Performs a preorder traversal on this binary tree by calling an overloaded, recursive preorder method that starts with the root
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if(node == null) {
            return;
        } else {
            tempList.addToRear(node.element);
            preorder(node.left, tempList);
            preorder(node.right, tempList);
        }
    }

    /**
     * Performs a postorder traversal on this binary tree by calling an overloaded, recursive postorder method that starts with the root
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if(node == null) {
            return;
        } else {
            postorder(node.left, tempList);
            postorder(node.right, tempList);
            tempList.addToRear(node.element);
        }
    }

    /**
     * Performs a levelorder traversal on this binary tree, using a queue
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void levelorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if(node == null) {
            return;
        }

        QueueADT<BinaryTreeNode<T>> queue = new LinkedQueue<>();
        queue.enqueue(node);

        while(!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();
            tempList.addToRear(current.element);

            if(current.left != null) {
                queue.enqueue(current.left);
            }

            if(current.right != null) {
                queue.enqueue(current.right);
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
        inorder(root, tempList);

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
        preorder(root, tempList);

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
        postorder(root, tempList);

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
        levelorder(root, tempList);

        return tempList.iterator();
    }
}
