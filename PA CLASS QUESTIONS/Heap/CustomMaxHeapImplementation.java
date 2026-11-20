import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

class CustomMaxHeapImplementation {
    ArrayList<Integer> heap = new ArrayList<>();

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;
        heapifyup(index);
    }

    public void heapifyup(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) > heap.get(parent)) {
                Collections.swap(heap, index, parent);
                index = parent; 
            } else {
                break; 
            }
        }
    }

    @SuppressWarnings("SizeReplaceableByIsEmpty")
    int deleteMax() {
        if (heap.size() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        
        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        
        if (heap.size() > 0) {
            heap.set(0, last); 
            heapifydown(0);    
        }
        
        return max;
    }

    void heapifydown(int index) {
        int size = heap.size();
        while (true) {
            int largest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2; 

            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < size && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest != index) {
                Collections.swap(heap, index, largest);
                index = largest;
            } else {
                break; 
            }
        }
    }

    // Fixed: Added the display method to print the internal array structure
    public void display() {
        System.out.println("Heap: " + heap);
    }

    public static void main(String[] args) {
        CustomMaxHeapImplementation maxHeap = new CustomMaxHeapImplementation();
        maxHeap.insert(50);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.insert(20);
        
        System.out.print("Before deleteMax -> ");
        maxHeap.display(); // Prints: [50, 40, 20, 20, 30, 10]
        
        System.out.println("Removing max element: " + maxHeap.deleteMax());
        
        System.out.print("After deleteMax  -> ");
        maxHeap.display(); // Prints: [40, 30, 20, 20, 10]
    }
}
