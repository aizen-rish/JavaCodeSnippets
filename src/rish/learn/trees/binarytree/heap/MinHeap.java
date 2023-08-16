package rish.learn.trees.binarytree.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap implements Heap<Integer> {

    private List<Integer> tree;

    public MinHeap() {
        this.tree = new ArrayList<>();
    }

    @Override
    public void insert(Integer ele) {

        tree.add(ele);

        if (tree.size() == 0) {
            return;
        }

        int size = tree.size();
        heapifyInternal(size / 2 - 1);
    }

    private void heapifyInternal(int start) {
        for (int i = start; i >= 0; i--) {
            heapify(i);
        }
    }

    @Override
    public void delete(Integer num) {

        int size = tree.size();
        int index = tree.indexOf(num);

        swap(index, size - 1);

        tree.remove(size - 1);
        heapifyInternal(size / 2 - 1);
    }

    private void swap(int i, int j) {
        int temp = tree.get(i);
        tree.set(i, tree.get(j));
        tree.set(j, temp);
    }

    @Override
    public Integer peek() throws IllegalAccessException {

        if (tree.size() == 0) {
            throw new IllegalAccessException("Heap is empty!");
        }

        return tree.get(0);
    }

    @Override
    public Integer poll() throws IllegalAccessException {

        if (tree.size() == 0) {
            throw new IllegalAccessException("Heap is empty!");
        }

        int size = tree.size();
        int root = tree.get(0);

        swap(0, size - 1);

        tree.remove(size - 1);
        heapifyInternal(size / 2 - 1);

        return root;
    }

    @Override
    public void heapify(int index) {

        int size = tree.size();
        int smallest = index;

        int left = 2 * index + 1;
        int right = left + 1;

        if (left < size && tree.get(left) < tree.get(smallest)) {
            smallest = left;
        }

        if (right < size && tree.get(right) < tree.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(smallest, index);
            heapify(smallest);
        }
    }

    @Override
    public void print() {
        for (Integer t : tree) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

}
