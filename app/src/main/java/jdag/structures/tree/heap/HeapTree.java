package jdag.structures.tree.heap;

public class HeapTree
{
    private int[] heap;
    private int size;

    public HeapTree (final int capacity) {
        heap = new int[capacity];
    }

    public int delete (final int index) {
        // must keep the tree complete -> will take the rightmost value
        // if replacement is greater than parent, heapify above, otherwise, heapify below

        if (isEmpty ()) {
            throw new IndexOutOfBoundsException ("Heap is empty");
        }
        int parent = getParent (index);
        int deletedValue = heap[index];
        // replace value with right most node
        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]) {
            // if the node was the root, or the value of the node is smalle than the parent
            fixHeapBelow (index, size - 1);
        } else {
            fixHeapAbove (index);
        }
        size--;
        return deletedValue;
    }


    public int getChild (final int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public int getParent (final int index) {
        return (index - 1) / 2;
    }

    public int peek () {
        if (isEmpty ()) {
            throw new IndexOutOfBoundsException ("Heap is empty");
        }
        return heap[0];
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public boolean isFull () {
        return size == heap.length;
    }


    public void insert (final int value) {
        if (isFull ()) {
            throw new IndexOutOfBoundsException ("The heap is full");
        }
        heap[size] = value;
        fixHeapAbove (size);
        size++;
    }

    // ###################################################################################################

    private void fixHeapAbove (final int originalIndex) {
        int newValue = heap[originalIndex];
        int index = originalIndex;
        while (index > 0 && newValue > heap[getParent (index)]) {
            heap[index] = heap[getParent (index)];
            index = getParent (index);
        }
        heap[index] = newValue;
    }

    private void fixHeapBelow (final int originalIndex, final int lastHeapIndex) {
        int childToSwap;

        int index = originalIndex;
        while (index <= lastHeapIndex) {
            int leftChild = getChild (index, true);
            int rightChild = getChild (index, false);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    // no right child, swap left one
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    // swap
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }
        }
    }

    public void print () {
        for (int i : heap) {
            System.out.println (i);
        }
    }
}
