package rish.learn.trees.binarytree.heap;

public interface Heap<T> {

    void insert(T ele);

    void delete(T ele);

    T peek() throws IllegalAccessException;

    T poll() throws IllegalAccessException;

    void heapify(int index);

    void print();

}
