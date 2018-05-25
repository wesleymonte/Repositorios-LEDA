package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(top == -1) {
			empty = true;
		}
		return empty;
	}

	@Override
	public boolean isFull() {
		boolean full = false;
		if(top + 1 == array.length) {
			full = true;
		}
		return full;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()) {
			top += 1;
			array[top] = element;
		}
		else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T aux = null;
		if(!isEmpty()) {
			aux = array[top];
			array[top] = null;
			top -= 1;
		}
		else {
			throw new StackUnderflowException();
		}
		return aux;
	}

}
