package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		else if(element != null) {
			top.insertFirst(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T rtn = null;
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			rtn = ((SingleLinkedListImpl<T>) top).getHead().getData();
			top.removeFirst();
		}
		return rtn;
	}

	@Override
	public T top() {
		T rtn = null;
		if(!isEmpty()) {
			rtn = ((SingleLinkedListImpl<T>) top).getHead().getData();
		}
		return rtn;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(top.isEmpty()) {
			empty = true;
		}
		return empty;
	}

	@Override
	public boolean isFull() {
		boolean full = false;
		if(top.size() == this.size) {
			full = true;
		}
		return full;
	}

}
