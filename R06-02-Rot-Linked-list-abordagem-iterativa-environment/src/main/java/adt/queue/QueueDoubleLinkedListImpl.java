package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		else if(element != null) {
			list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T rtn = null;
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		else {
			rtn = ((SingleLinkedListImpl<T>) list).getHead().getData();
			list.removeFirst();
		}
		return rtn;
	}

	@Override
	public T head() {
		T rtn = null;
		if(!isEmpty()) {
			rtn = ((SingleLinkedListImpl<T>) list).getHead().getData();
		}
		return rtn;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(list.isEmpty()) {
			empty = true;
		}
		return empty;
	}

	@Override
	public boolean isFull() {
		boolean full = false;
		if(list.size() == this.size) {
			full = true;
		}
		return full;
	}

}
