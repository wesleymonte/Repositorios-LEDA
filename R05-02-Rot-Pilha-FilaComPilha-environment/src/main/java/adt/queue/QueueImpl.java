package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(tail == -1) {
			empty = true;
		}
		return empty;
	}

	@Override
	public boolean isFull() {
		boolean full = false;
		if(tail + 1 == array.length) {
			full = true;
		}
		return full;
	}

	private void shiftLeft() {
		for(int i = 0; i < tail; i++) {
			array[i] = array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()) {
			tail += 1;
			array[tail] = element;
		}
		else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T aux = null;
		if(!isEmpty()) {
			aux = array[0];
			shiftLeft();
		}
		else {
			throw new QueueUnderflowException();
		}
		return aux;
	}

}
