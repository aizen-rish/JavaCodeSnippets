package rish.learn.trees.binarytree.heap;

public class HeapRunner {

    public static void main(String[] args) {

        Heap<Integer> maxHeap = new MaxHeap();

        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(5);
        maxHeap.insert(2);

        maxHeap.print();

        Heap<Integer> minHeap = new MinHeap();

        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(9);
        minHeap.insert(5);
        minHeap.insert(2);

        minHeap.print();
        minHeap.delete(9);;
        minHeap.print();
    }

}
