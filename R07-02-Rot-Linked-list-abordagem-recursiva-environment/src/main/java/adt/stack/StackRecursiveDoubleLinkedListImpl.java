package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;
import adt.linkedList.RecursiveSingleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
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

	@SuppressWarnings("unchecked")
	@Override
	public T pop() throws StackUnderflowException {
		T rtn = null;
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			rtn = ((RecursiveSingleLinkedListImpl<T>) top).getData();
			top.removeFirst();
		}
		return rtn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T top() {
		T rtn = null;
		if(!isEmpty()) {
			rtn = ((RecursiveSingleLinkedListImpl<T>) top).getData();
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
