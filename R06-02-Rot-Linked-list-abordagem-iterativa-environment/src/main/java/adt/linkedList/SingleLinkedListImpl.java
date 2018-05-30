package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (getHead().isNIL());
	}

	@Override
	public int size() {
		int count = 0;
		SingleLinkedListNode<T> aux = getHead();
		while(!aux.isNIL()) {
			count += 1;
			aux = aux.getNext();
		}
		return count;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = getHead();
		while(!aux.isNIL() && !aux.getData().equals(element)) {
			aux = aux.getNext();
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			SingleLinkedListNode<T> aux = getHead();
			if(isEmpty()) {
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, null);
				newNode.setNext(getHead());
				setHead(newNode);
			}
			else {
				while(!aux.getNext().isNIL()) {
					aux = aux.getNext();
				}
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, aux.getNext());
				aux.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty() && element != null) {
			SingleLinkedListNode<T> aux = getHead();
			if(getHead().getData().equals(element)) {
				setHead(getHead().getNext());
			}
			else {
				while(!aux.isNIL() && !aux.getNext().getData().equals(element)){
					aux = aux.getNext();
				}
				if(!aux.isNIL()) {
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		SingleLinkedListNode<T> aux = getHead();
		int count = 0;
		while(!aux.isNIL()) {
			array[count] = aux.getData();
			count += 1;
			aux = aux.getNext();
		}
		return array;
		
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
