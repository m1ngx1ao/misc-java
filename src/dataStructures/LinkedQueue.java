package dataStructures;

public class LinkedQueue<T> {
	private LinkedQueueElement<T> first;
	private LinkedQueueElement<T> last;

	public LinkedQueue() {
		first = null;
		last = null;
	}

	public void enqueue(T e) {
		LinkedQueueElement<T> newLast = new LinkedQueueElement<T>();
		newLast.value = e;
		if (first == null) {
			first = newLast;
			last = newLast;
		} else {
			last.next = newLast;
			last = newLast;
		}
	}

	public T dequeue() {
		if (first == null) {
			return null;
		}
		T result = first.value;
		first = first.next;
		return result;
	}
}