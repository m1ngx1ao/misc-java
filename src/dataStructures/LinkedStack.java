package dataStructures;

public class LinkedStack<T> {
	private LinkedStackElement<T> last;

	public LinkedStack() {
		last = null;
	}

	public void push(T e) {
		LinkedStackElement<T> newLast = new LinkedStackElement<T>();
		newLast.value = e;
		newLast.previous = last;
		last = newLast;
	}

	public T pop() {
		if (last == null) {
			return null;
		}
		T result = last.value;
		last = last.previous;
		return result;
	}
}