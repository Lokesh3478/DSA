package LinearDS.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue<T> {
    private Object[] data;
    private int size;
    private int last;
    private Comparator<T> comparator;

    public PriorityQueue(int size, Comparator<T> comparator) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null.");
        }
        this.data = new Object[size];
        this.size = size;
        this.last = 0;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return last == 0;
    }

    public boolean isFull() {
        return size == last;
    }

    public boolean add(T ele) {
        if (isFull()) {
            resize();
        }
        data[last++] = ele;
        siftUp();
        return true;
    }

    private void siftUp() {
        int child = last - 1;
        int parent = getParent(child);
        while (child > 0 && comparator.compare(get(child), get(parent)) < 0) {
            swap(parent, child);
            child = parent;
            parent = getParent(parent);
        }
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty.");
        }
        T val = get(0);
        data[0] = data[--last];
        siftDown();
        return val;
    }

    private void siftDown() {
        int parent = 0;
        while (parent < last) {
            int heap = parent;
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;

            if (left < last && comparator.compare(get(left), get(heap)) < 0) {
                heap = left;
            }
            if (right < last && comparator.compare(get(right), get(heap)) < 0) {
                heap = right;
            }
            if (heap != parent) {
                swap(parent, heap);
                parent = heap;
            } else {
                break;
            }
        }
    }

    private void resize() {
        size *= 2;
        data = Arrays.copyOf(data, size);
    }

    private void swap(int parent, int child) {
        Object temp = data[parent];
        data[parent] = data[child];
        data[child] = temp;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    @SuppressWarnings("unchecked")
    private T get(int index) {
        return (T) data[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, last));
    }
}
