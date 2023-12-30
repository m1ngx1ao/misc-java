package dataStructures;

public class ArrayStack<T> {
	private Object[] stack;
	private int counter;

	public ArrayStack() {
        stack = new Object[10];
        counter = 0;
	}

	public void push(T e) {
		stack[counter] = e;
        counter++; 
	}

	public T pop() {
        if (counter == 0) {
            return null;
        }
		counter--;
		return (T) stack[counter];
	}
}
