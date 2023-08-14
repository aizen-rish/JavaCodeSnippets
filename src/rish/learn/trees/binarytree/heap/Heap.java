package rish.learn.trees.binarytree.heap;

public interface Heap<T> {

    void heapify(int index);

    void insert(T ele);

    void delete(T ele);

    void print();

}
