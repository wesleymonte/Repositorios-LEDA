package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if (getData() == null) {
			empty = true;
		}
		return empty;
	}

	@Override
	public int size() {
		int count = 0;
		if (isEmpty()) {
			count += 0;
		} else {
			count += 1 + getNext().size();
		}
		return count;
	}

	@Override
	public T search(T element) {
		T rtn = null;
		if (element != null) {
			if (isEmpty()) {
				rtn = null;
			} else {
				if (getData().equals(element)) {
					rtn = getData();
				} else {
					rtn = getNext().search(element);
				}
			}
		}
		return rtn;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (isEmpty()) {
				// NÃO FAZ NADA PQ A LISTA ESTÁ VAZIA
			} else {
				if (getData().equals(element)) {
					setData(getNext().getData());
					setNext(getNext().getNext());
				} else {
					getNext().remove(element);
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size()];
		toArray(array, this, 0);
		return array;
	}

	private void toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (!node.isEmpty()) {
			array[index] = node.getData();
			toArray(array, node.getNext(), index + 1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
