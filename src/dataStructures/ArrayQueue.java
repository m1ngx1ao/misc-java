package dataStructures;

public class ArrayQueue<T> {
	private Object[] queue;
	private int nextFree;
	private int first;

	public ArrayQueue() {
        queue = new Object[10];
        nextFree = 0;
		first = -1;
	}

	public void enqueue(T e) {
		queue[nextFree] = e;
		if (first == -1) {
			first = nextFree;
		}
		nextFree = (nextFree + 1) % 10;
	}

	public T dequeue() {
        if (first == -1) {
            return null;
        }
		int oldFirst = first;
		first = (first + 1) % 10;
		if (nextFree == first) {
			first = -1;
		}
		return (T) queue[oldFirst];
	}
}