package Trees.Heaps;

import Trees.BinaryTreeNode;

/**
 * HeapNode represents a node in a heap
 * @param <T> the element type of the node
 */
public class HeapNode<T> extends BinaryTreeNode<T> {

    /**
     * Reference to the next node in the list
     */
    protected HeapNode<T> parent;

    /**
     * Creates a new tree node with the specified data
     *
     * @param element the element that will become a part of the new tree node
     */
    public HeapNode(T element) {
        super(element);
        parent = null;
    }
}
