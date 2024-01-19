package Trees;

import Lists.ArrayUnorderedList;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

import java.util.Iterator;

/**
 * ArrayBinarySearchTree represents an array implementation of a binary search tree
 * @param <T> the type of elements held in this collection
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {

    protected int height;
    protected int maxIndex;

    /**
     * Creates an empty binary search tree
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search with the specified element as its root
     *
     * @param element the element that will become the root of the new binary search tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 0;
        maxIndex = -1;
    }

    /**
     * Returns the height of this tree
     *
     * @return the height of this tree
     */
    private int calculateHeight() {
        return (int) (Math.log(count) / Math.log(2));
    }

    /**
     * Adds the specified element to the proper location in this tree
     *
     * @param element the element to be added to this tree
     *
     */
    @Override
    public void addElement(T element) {
        if(tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }

        Comparable<T> comparableElement = (Comparable<T>) element;

        if(isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while(!added) {
                if(comparableElement.compareTo(tree[currentIndex]) < 0) {
                    //go left
                    if(tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if(currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    //go right
                    if(tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if(currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }

        height = calculateHeight();
        count++;
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
        boolean found = false;

        if (isEmpty())
            return result;

        for (int i = 0; (i <= maxIndex) && !found; i++) {
            if ((tree[i] != null) && targetElement.equals(tree[i]))
            {
                found = true;
                result = tree[i] ;
                replace(i);
                count--;
            }
        }

        if (!found)
            throw new ElementNotFoundException("element not found in the binary tree");

        int temp = maxIndex;
        maxIndex = -1;
        for (int i = 0; i <= temp; i++)
            if (tree[i] != null)
                maxIndex = i;

        height = calculateHeight();

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
        while (contains(targetElement))
            removeElement(targetElement);
    }

    /**
     * Removes and returns the smallest element from this tree
     *
     * @return the smallest element from this tree
     */
    @Override
    public T removeMin() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("The tree is empty");
        else
        {
            int currentIndex = 1;
            int previousIndex = 0;
            while (tree[currentIndex] != null && currentIndex <= tree.length)
            {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 1;
            }
            result = tree[previousIndex] ;
            replace(previousIndex);
        }

        count--;

        return result;
    }

    /**
     * Removes and returns the largest element from this tree
     *
     * @return the largest element from this tree
     */
    @Override
    public T removeMax() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException ("binary tree");
        else
        {
            int currentIndex = 2;
            int previousIndex = 0;
            while (tree[currentIndex] != null && currentIndex <= maxIndex)
            {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 2;
            }
            result = tree[previousIndex] ;
            replace(previousIndex);
        }

        count--;

        return result;
    }

    /**
     * Returns a reference to the smallest element in this tree
     *
     * @return a reference to the smallest element in this tree
     */
    @Override
    public T findMin() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException ("binary tree");
        else {
            int currentIndex = 0;
            while ((currentIndex*2+1 <= maxIndex) && (tree[currentIndex*2+1] != null))
                currentIndex = currentIndex*2+1;
            result = tree[currentIndex] ;
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

        if (isEmpty())
            throw new EmptyCollectionException ("binary tree");
        else {
            int currentIndex = 0;
            while ((currentIndex*2+2 <= maxIndex) && (tree[currentIndex*2+2] != null))
                currentIndex = currentIndex*2+2;
            result = tree[currentIndex] ;
        }
        return result;
    }

    protected void replace (int targetIndex)
    {
        int currentIndex, parentIndex, temp, oldIndex, newIndex;
        ArrayUnorderedList<Integer> oldlist = new ArrayUnorderedList<Integer>();
        ArrayUnorderedList<Integer> newlist = new ArrayUnorderedList<Integer>();
        ArrayUnorderedList<Integer> templist = new ArrayUnorderedList<Integer>();
        Iterator<Integer> oldIt, newIt;

        // if target node has no children
        if ((targetIndex*2+1 >= tree.length) || (targetIndex*2+2 >= tree.length))
            tree[targetIndex] = null;

            // if target node has no children
        else if ((tree[targetIndex*2+1] == null) && (tree[targetIndex*2+2] == null))
            tree[targetIndex] = null;

            // if target node only has a left child
        else if ((tree[targetIndex*2+1] != null) && (tree[targetIndex*2+2] == null)) {

            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist

            // fill newlist
            currentIndex = targetIndex*2+1;
            templist.addToRear(Integer.valueOf(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer)templist.removeFirst()).intValue();
                newlist.addToRear(Integer.valueOf(currentIndex));
                if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                    templist.addToRear(Integer.valueOf(currentIndex*2+1));
                    templist.addToRear(Integer.valueOf(currentIndex*2+2));
                }
            }

            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(Integer.valueOf(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer)templist.removeFirst()).intValue();
                oldlist.addToRear(Integer.valueOf(currentIndex));
                if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                    templist.addToRear(Integer.valueOf(currentIndex*2+1));
                    templist.addToRear(Integer.valueOf(currentIndex*2+2));
                }
            }

            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        }

        // if target node only has a right child
        else if ((tree[targetIndex*2+1] == null) && (tree[targetIndex*2+2] != null)) {

            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist

            // fill newlist
            currentIndex = targetIndex*2+2;
            templist.addToRear(Integer.valueOf(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer)templist.removeFirst()).intValue();
                newlist.addToRear(Integer.valueOf(currentIndex));
                if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                    templist.addToRear(Integer.valueOf(currentIndex*2+1));
                    templist.addToRear(Integer.valueOf(currentIndex*2+2));
                }
            }

            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(Integer.valueOf(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer)templist.removeFirst()).intValue();
                oldlist.addToRear(Integer.valueOf(currentIndex));
                if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                    templist.addToRear(Integer.valueOf(currentIndex*2+1));
                    templist.addToRear(Integer.valueOf(currentIndex*2+2));
                }
            }

            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        }

        // target node has two children
        else
        {
            currentIndex = targetIndex*2+2;

            while (tree[currentIndex*2+1] != null) {
                currentIndex = currentIndex*2+1;
            }

            tree[targetIndex] = tree[currentIndex];

            // the index of the root of the subtree to be replaced
            int currentRoot = currentIndex;

            // if currentIndex has a right child
            if (tree[currentRoot*2+2] != null) {

                // fill newlist with indices of nodes that will replace
                // the corresponding indices in oldlist

                // fill newlist
                currentIndex = currentRoot*2+2;
                templist.addToRear(Integer.valueOf(currentIndex));
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer)templist.removeFirst()).intValue();
                    newlist.addToRear(Integer.valueOf(currentIndex));
                    if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                        templist.addToRear(Integer.valueOf(currentIndex*2+1));
                        templist.addToRear(Integer.valueOf(currentIndex*2+2));
                    }
                }

                // fill oldlist
                currentIndex = currentRoot;
                templist.addToRear(Integer.valueOf(currentIndex));
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer)templist.removeFirst()).intValue();
                    oldlist.addToRear(Integer.valueOf(currentIndex));
                    if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                        templist.addToRear(Integer.valueOf(currentIndex*2+1));
                        templist.addToRear(Integer.valueOf(currentIndex*2+2));
                    }
                }

                // do replacement
                oldIt = oldlist.iterator();
                newIt = newlist.iterator();
                while (newIt.hasNext()) {
                    oldIndex = oldIt.next();
                    newIndex = newIt.next();
                    tree[oldIndex] = tree[newIndex];
                    tree[newIndex] = null;
                }
            }
            else
                tree[currentRoot] = null;
        }
    }



}
