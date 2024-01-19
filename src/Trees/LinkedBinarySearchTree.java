package Trees;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

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
        BinaryTreeNode<T> temp = new BinaryTreeNode<T>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty())
            root = temp;
        else {
            BinaryTreeNode<T> current = root;
            boolean added = false;

            while (!added) {
                if (comparableElement.compareTo(current.element) < 0) {
                    if (current.left == null) {
                        current.left = temp;
                        added = true;
                    } else
                        current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = temp;
                        added = true;
                    } else
                        current = current.right;
                }
            }
        }
        count++;
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it. Throws a ElementNotFoundException if the specified target
     * element is not found in this tree.
     *
     * @param   targetElement the element to be removed from this tree
     * @return  the element removed from this tree
     * @throws  ElementNotFoundException if the specified element is not found in this tree
     */
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {

        T result = null;

        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            } else {
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;

                if (((Comparable) targetElement).compareTo(root.element) < 0)
                    current = root.left;
                else
                    current = root.right;

                while (current != null && !found) {
                    if (targetElement.equals(current.element)) {
                        found = true;
                        count--;
                        result = current.element;

                        if (current == parent.left)
                            parent.left = replacement(current);
                        else
                            parent.right = replacement(current);
                    } else {
                        parent = current;

                        if (((Comparable) targetElement).compareTo(current.element) < 0)
                            current = current.left;
                        else
                            current = current.right;
                    }
                }
                if (!found)
                    throw new ElementNotFoundException("binary search tree");
            }
        }
        return result;

    }

    /**
     * Returns a reference to a node that will replace the one
     * specified for removal. In the case where the removed node has
     * two children, the inorder successor is used as its replacement.
     *
     * @param   current the node to be removeed
     * @return  a reference to the replacing node
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> current) {
        BinaryTreeNode<T> result = null;

        if ((current.left == null) && (current.right == null))
            result = null;
        else if ((current.left != null) && (current.right == null))
            result = current.left;
        else if ((current.left == null) && (current.right != null))
            result = current.right;
        else {
            BinaryTreeNode<T> temp = current.right;
            BinaryTreeNode<T> parent = current;

            while (temp.left != null) {
                parent = temp;
                temp = temp.left;
            }

            if (current.right == temp)
                temp.left = current.left;
            else {
                parent.left = temp.right;
                temp.right = current.right;
                temp.left = current.left;
            }
            result = temp;
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
        removeElement(targetElement);

        boolean occur = true;
        while(occur) {
            try {
                removeElement(targetElement);
            } catch(ElementNotFoundException e) {
                occur = false;
            }
        }
    }

    /**
     * Removes and returns the smallest element from this tree
     *
     * @return the smallest element from this tree
     */
    @Override
    public T removeMin() {
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> parent = null;

        while(current.left != null) {
            parent = current;
            current = current.left;
        }

        if(current == root) {
            root = root.right;
            return current.element;
        }
        //if it's a leaf
        if(current.right == null) {
            parent.left = null;
            return current.element;
        }
        //internal node
        parent.left = current.right;
        return current.element;
    }

    /**
     * Removes and returns the largest element from this tree
     *
     * @return the largest element from this tree
     */
    @Override
    public T removeMax() {
        T result = null;

        if(isEmpty()) {
            throw new EmptyCollectionException("The tree is empty");
        } else {
            if(root.right == null) {
                result = root.element;
                root = root.left;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;

                while(current.right != null) {
                    parent = current;
                    current = current.right;
                }

                result = current.element;
                parent.right = current.left;
            }

            count--;
        }
        return result;
    }

    /**
     * Returns a reference to the smallest element in this tree
     *
     * @return a reference to the smallest element in this tree
     */
    @Override
    public T findMin() throws EmptyCollectionException {
        T result = null;

        if(isEmpty()) {
            throw new EmptyCollectionException("The tree is empty");
        } else {
            BinaryTreeNode<T> current = root;

            while(current.left != null) {
                current = current.left;
            }

            result = current.element;
        }
        return result;
    }

    /**
     * Returns a reference to the largest element in this tree
     *
     * @return a reference to the largest element in this tree
     */
    @Override
    public T findMax() {
        T result = null;

        if(isEmpty()) {
            throw new EmptyCollectionException("The tree is empty");
        } else {
            BinaryTreeNode<T> current = root;

            while(current.right != null) {
                current = current.right;
            }

            result = current.element;
        }
        return result;
    }
}
