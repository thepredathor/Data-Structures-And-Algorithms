
package data_structures.heap;

import java.util.Arrays;


public class Heap {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    int[] heap; // internal array aka the heap
    int size = 0; // size field to know when the no of elements reaches maxLength

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors 
    //~ ----------------------------------------------------------------------------------------------------------------

    public Heap(int length) { // constructor given "length" as parameter
        heap = new int[length]; // init array with max length as length param
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Case: Heap representation with internal array
    public static void main(String[] args) throws HeapCapacityOverFlowException {
        Heap heap = new Heap(13);
        heap.insertValue(100);
        heap.insertValue(88);
        heap.insertValue(25);
        heap.insertValue(87);
        heap.insertValue(16);
        heap.insertValue(8);
        heap.insertValue(12);
        heap.insertValue(86);
        heap.insertValue(50);
        heap.insertValue(2);
        heap.insertValue(15);
        heap.insertValue(3);

        System.out.println(Arrays.toString(heap.heap));

        heap.pop();

        System.out.println(Arrays.toString(heap.heap));
    }

    public int capacity() { // capacity is the length of the array
        return heap.length;
    }

    public int firstNode() { // first Node in the heap aka "root"
        return heap[0];
    }

    public int lastNode() { // last node
        return heap[size - 1];
    }

    public int getLeftChildIndex(int index) { // left child index of a node index
        return (index * 2) + 1;
    }

    public int getRightChildIndex(int index) { // right child index of a node index
        return (index * 2) + 2;
    }

    public int getParentIndex(int index) { // parent index of a node index
        return (index - 1) / 2;
    }

    public int insertValue(int value) throws HeapCapacityOverFlowException { // algorithm for node insertion
        if (hasCapacity()) { // check if current heap size is smaller than max length so insertion can happen
            heap[size] = value; // if yes, set the last element(element at index current heap size) to the new value
            size++; // increase current heap size by 1
        } else {
            throw new HeapCapacityOverFlowException(); // if no throw exception that heap can't accept any more values
        }

        // trickle up the value to the correct position
        int valueIndex = size - 1; // current position of inserted value ( index is current heap size - 1)
        int parentIndex;
        while ((parentIndex = getParentIndex(valueIndex)) > 0) { // assign parent index var to parent index of the current value index and do while parent index does not decrease smaller than the first index
            if (heap[parentIndex] < value) { // if the value of the parent of the current inserted value is smaller
                int temp = heap[parentIndex]; // switch the parent value with inserted value (trickle up the inserted value)
                heap[parentIndex] = value;
                heap[valueIndex] = temp;
                valueIndex = parentIndex; // the index of the value to be inserted becomes the index of the parent
            } else {
                break; // else the value is in the correct position and no trickling should happen anymore (break the while loop)
            }
        }

        return value;
    }

    public boolean pop() { // algorithm for node deletion (popping)
        heap[0] = heap[size - 1]; // the root gets deleted and becomes the last node in the heap
        heap[size - 1] = 0; // deinit last position in the heap
        int trickleNode = heap[0]; // the trickle node that needs trickling down from the root is the new root
        int trickleNodeIndex = 0; // starting index of node that needs trickling down is 0 (root index)

        int leftChildIndex, rightChildIndex;
        while (((leftChildIndex = getLeftChildIndex(trickleNodeIndex)) <= (size - 1) // find the left child index of the node that needs trickling down
            ) && ((rightChildIndex = getRightChildIndex(trickleNodeIndex)) <= (size - 1))) { // find the right child index of the node that needs trickling down while both not getting over the current size of the heap
            if (heap[leftChildIndex] < heap[rightChildIndex]) { // take whichever child is bigger than the value of the node that needs trickling down and swap them
                int temp = heap[rightChildIndex];
                heap[rightChildIndex] = trickleNode;
                heap[trickleNodeIndex] = temp;
                trickleNodeIndex = rightChildIndex; // the index of the node that needs trickling down is swapped
            } else if (heap[leftChildIndex] > heap[rightChildIndex]) {
                int temp = heap[leftChildIndex];
                heap[leftChildIndex] = trickleNode;
                heap[trickleNodeIndex] = temp;
                trickleNodeIndex = leftChildIndex;
            }
        }

        return true;
    }

    public boolean hasCapacity() {
        return size < heap.length;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Nested Classes 
    //~ ----------------------------------------------------------------------------------------------------------------

    private class HeapCapacityOverFlowException extends Throwable {
    }
}
