package Algorithms;

import Lists.DoubleLinkedList;
import Lists.DoubleNode;
import Lists.DoubleUnorderedList;
import Lists.LinkedList;

/**
 * SortingAndSearchingList contains several implementations of sorting and searching algorithms.
 *          * WARNING
 *          *
 *          * THE CODE ABOVE IS NOT WORKING PURPOSELY BECAUSE THE
 *          * BINARY SEARCH METHOD P.E. IN THE SortingAndSearchingList CLASS
 *          * DOESN'T MAKE SENSE IMPLEMENTING IT FOR A LINKED LIST
 *          * BECAUSE IT INCREASES THE TIME COMPLEXITY OF THE ALGORITHM
 */
public class SortingAndSearchingList {

    /**
     * Sorts the specified list of elements
     * using a linear search algorithm.
     *
     * @param list the list to be searched
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean linearSearch(DoubleLinkedList<T> list, T target) {
        boolean found = false;
        DoubleNode<T> current = list.front;
        while(!found && current != null) {
            if(current.getElement().compareTo(target) == 0) {
                found = true;
            }
            current = current.getNext();
        }
        return found;
    }

/**
     * Searches the specified list of elements
     * using a binary search algorithm.
     *
     * @param list the list to be searched
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean binarySearch(DoubleLinkedList<T> list, T target) {
        boolean found = false;
        DoubleNode<T> current = list.front;
        while (!found && current != null) {
            if (current.getElement().compareTo(target) == 0) {
                found = true;
            }
            current = current.getNext();
        }
        return found;
    }

    /**
     * Sorts the specified list of elements
     * using the selection sort algorithm.
     *
     * @param list the list to be sorted
     */
    public static <T extends Comparable<? super T>> void selectionSort(DoubleLinkedList<T> list) {
        DoubleNode<T> current = list.front;
        DoubleNode<T> min;
        T temp;
        while(current != null) {
            min = current;
            while(min != null) {
                if(min.getElement().compareTo(current.getElement()) < 0) {
                    temp = min.getElement();
                    min.setElement(current.getElement());
                    current.setElement(temp);
                }
                min = min.getNext();
            }
            current = current.getNext();
        }
    }

    /**
     * Sorts the specified list of elements
     * using the insertion sort algorithm.
     *
     * @param list the list to be sorted
     */
    public static <T extends Comparable<? super T>> void insertionSort(DoubleLinkedList<T> list) {
        DoubleNode<T> current = list.front;
        DoubleNode<T> previous = null;
        DoubleNode<T> next = null;
        T temp;
        while(current != null) {
            previous = current.getPrevious();
            next = current.getNext();
            while(previous != null && previous.getElement().compareTo(current.getElement()) > 0) {
                temp = previous.getElement();
                previous.setElement(current.getElement());
                current.setElement(temp);
                previous = previous.getPrevious();
            }
            current = next;
        }
    }

    /**
     * Sorts the specified list of elements
     * using the bubble sort algorithm.
     *
     * @param list the list to be sorted
     */
    public static <T extends Comparable<? super T>> void bubbleSort(DoubleLinkedList<T> list) {
        DoubleNode<T> current = list.front;
        DoubleNode<T> next = null;
        T temp;
        while(current != null) {
            next = current.getNext();
            while(next != null) {
                if(next.getElement().compareTo(current.getElement()) < 0) {
                    temp = next.getElement();
                    next.setElement(current.getElement());
                    current.setElement(temp);
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
    }

    /**
     * Sorts the specified list of elements
     * using the quick sort algorithm.
     *
     * @param list the list to be sorted
     */
    private static <T extends Comparable<? super T>> void quickSort(DoubleLinkedList<T> list, DoubleNode<T> first, DoubleNode<T> last) {
        if(first != null && last != null && first != last && first != last.getNext()) {
            DoubleNode<T> pivot = findPartition(list, first, last);
            quickSort(list, first, pivot.getPrevious());
            quickSort(list, pivot.getNext(), last);
        }
    }

    /**
     * Partitions the specified list of elements
     * using the quick sort algorithm.
     *
     * @param list the list to be sorted
     * @param first the first element in the list
     * @param last the last element in the list
     * @return the pivot
     */
    private static <T extends Comparable<? super T>> DoubleNode<T> findPartition(DoubleLinkedList<T> list, DoubleNode<T> first, DoubleNode<T> last) {
        T pivot = first.getElement();
        DoubleNode<T> low = first;
        DoubleNode<T> high = last;
        while (low != high) {
            while (low != high && low.getElement().compareTo(pivot) <= 0) {
                low = low.getNext();
            }
            while (low != high && high.getElement().compareTo(pivot) > 0) {
                high = high.getPrevious();
            }
            if (low != high) {
                T temp = low.getElement();
                low.setElement(high.getElement());
                high.setElement(temp);
            }
        }
        while (high != first && high.getElement().compareTo(pivot) >= 0) {
            high = high.getPrevious();
        }
        if (pivot.compareTo(high.getElement()) > 0) {
            first.setElement(high.getElement());
            high.setElement(pivot);
            return high;
        } else {
            return first;
        }
    }

    /**
     * Sorts the specified list of elements
     * using the merge sort algorithm.
     *
     * @param list the list to be sorted
     */
    private static <T extends Comparable<? super T>> void mergeSort(DoubleLinkedList<T> list) {
        if(list.size() > 1) {
            DoubleUnorderedList<T> left = new DoubleUnorderedList<>();
            DoubleUnorderedList<T> right = new DoubleUnorderedList<>();
            int middle = list.size() / 2;
            DoubleNode<T> current = list.front;
            for(int i = 0; i < middle; i++) {
                left.addToRear(current.getElement());
                current = current.getNext();
            }
            for(int i = middle; i < list.size(); i++) {
                right.addToRear(current.getElement());
                current = current.getNext();
            }
            mergeSort(left);
            mergeSort(right);
            merge(list, left, right);
        }
    }

    /**
     * Merges the specified list of elements
     * using the merge sort algorithm.
     *
     * @param list the list to be sorted
     * @param left the left list
     * @param right the right list
     */
    private static <T extends Comparable<? super T>> void merge(DoubleLinkedList<T> list, DoubleLinkedList<T> left, DoubleLinkedList<T> right) {
        DoubleNode<T> current = list.front;
        DoubleNode<T> leftCurrent = left.front;
        DoubleNode<T> rightCurrent = right.front;
        while (leftCurrent != null && rightCurrent != null) {
            if (leftCurrent.getElement().compareTo(rightCurrent.getElement()) < 0) {
                current.setElement(leftCurrent.getElement());
                leftCurrent = leftCurrent.getNext();
            } else {
                current.setElement(rightCurrent.getElement());
                rightCurrent = rightCurrent.getNext();
            }
            current = current.getNext();
        }

        while (leftCurrent != null) {
            current.setElement(leftCurrent.getElement());
            leftCurrent = leftCurrent.getNext();
            current = current.getNext();
        }
        while (rightCurrent != null) {
            current.setElement(rightCurrent.getElement());
            rightCurrent = rightCurrent.getNext();
            current = current.getNext();
        }
    }

}




