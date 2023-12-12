package Trees;

import exceptions.ElementNotFoundException;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

    /**
     * Creates an empty binary search tree
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root
     *
     * @param element the element that will become the root of the new binary search tree
     */
    public LinkedBinarySearchTree(T element) {
        super(element);
    }

    /**
     * Adds the specified element to the proper location in this tree
     *
     * @param element the element to be added to this tree
     */
    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> node = new BinaryTreeNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if(isEmpty()) {
            super.root = node;
            return;
        }

        BinaryTreeNode<T> current = super.root;
        boolean added = false;

        while(!added) {
            // If the element is less than the current element, go left
            if(comparableElement.compareTo(current.element) < 0) {
                if(current.left == null) {
                    current.left = node;
                    added = true;
                } else {
                    current = current.left;
                }
                // If the element is greater than the current element, go right
            } else {
                if(current.right == null) {
                    current.right = node;
                    added = true;
                } else {
                    current = current.right;
                }
            }
        }
        super.count++;
    }

    /**
     * Removes and returns the specified element from this tree
     *
     * @param targetElement the element to be removed from this tree
     * @return the element removed from this tree
     * @throws ElementNotFoundException if the specified element is not found in this tree
     */
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;

        if(isEmpty()) {
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        } else {
            BinaryTreeNode<T> parent = null;
            if(((Comparable<T>) targetElement).equals(root.element)) {
                result = root.element;
                BinaryTreeNode<T> temp = replacement(root);
                if(temp == null) {
                    root = null;
                } else {
                    root.element = temp.element;
                    root.right = temp.right;
                    root.left = temp.left;
                }
                super.count--;
            } else {
                parent = root;
                if(((Comparable) targetElement).compareTo(root.element) < 0) {
                    result = removeElement(targetElement, root.left, parent);
                } else {
                    result = removeElement(targetElement, root.right, parent);
                }
            }
        }

        return result;
    }

    /**
     * Removes the node with the least value from the binary search tree
     * @param node the node to be removed
     * @return the node removed from the binary search tree
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;

        if((node.left == null) && (node.right == null)) {
            result = null;
        } else if((node.left != null) && (node.right == null)) {
            result = node.left;
        } else if((node.left == null) && (node.right != null)) {
            result = node.right;
        } else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while(current.left != null) {
                parent = current;
                current = current.left;
            }

            current.left = node.left;
            if(node.right != current) {
                parent.left = current.right;
                current.right = node.right;
            }

            result = current;
        }

        return result;
    }
    /**
     * Removes all occurrences of the specified element from this tree
     *
     * @param targetElement the element that the list will have all instances of it removed
     * @throws ElementNotFoundException if the specified element is not found in this tree
     */
    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {

    }

    /**
     * Removes and returns the smallest element from this tree
     *
     * @return the smallest element from this tree
     */
    @Override
    public T removeMin() {
        return null;
    }

    /**
     * Removes and returns the largest element from this tree
     *
     * @return the largest element from this tree
     */
    @Override
    public T removeMax() {
        return null;
    }

    /**
     * Returns a reference to the smallest element in this tree
     *
     * @return a reference to the smallest element in this tree
     */
    @Override
    public T findMin() {
        return null;
    }

    /**
     * Returns a reference to the largest element in this tree
     *
     * @return a reference to the largest element in this tree
     */
    @Override
    public T findMax() {
        return null;
    }
}
