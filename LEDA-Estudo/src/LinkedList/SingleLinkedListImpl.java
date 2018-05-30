package LinkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {
	
	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}
	
	
	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(head.isNIL()) {
			empty = true;
		}
		return empty;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()) {
			size += 1;
			aux = aux.next;
		}
		return size;
	}
	


	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL() && !aux.data.equals(element)) {
			aux = aux.next;
		}
		return aux.data;
		
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = head;
		if(isEmpty()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, null);
			newHead.next = head;
			head = newHead;
		}
		else {
			while(!aux.next.isNIL()) {
				aux = aux.next;
			}
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, null);
			newNode.next = aux.next;
			aux.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			SingleLinkedListNode<T> aux = head;
			if(head.data.equals(element)) {
				head = head.next;
			}
			else {
				while(!aux.isNIL() && !aux.next.data.equals(element)){
					aux = aux.next;
				}
				if(!aux.isNIL()) {
					aux.next = aux.next.next;
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = head;
		int count = 0;
		while(!aux.isNIL()) {
			array[count] = aux.data;
			aux = aux.next;
			count += 1;
		}
		return array;
	}

}
