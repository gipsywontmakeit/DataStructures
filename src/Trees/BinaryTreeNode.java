package Trees;

/**
 * BinaryTreeNode represents a node in a binary tree with a left and right child
 * @param <T> the type of elements held in this collection
 */
public class BinaryTreeNode<T> {

    /**
     * Reference to the element stored at this node
     */
    public T element;

    /**
     * Reference to the left child node
     */
    public BinaryTreeNode<T> left;

    /**
     * Reference to the right child node
     */
    public BinaryTreeNode<T> right;

    /**
     * Creates a new tree node with the specified data
     * @param element the element that will become a part of the new tree node
     */
    public BinaryTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

}
