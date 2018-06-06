package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>(null, null, this));
				if (getPrevious() == null) {
					setPrevious(new RecursiveDoubleLinkedListImpl<T>(null, this, null));
				}
			} else {
				getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (isEmpty()) {

			} else {
				if (getData().equals(element)) {
					if (getNext().isEmpty() && getPrevious().isEmpty()) {
						nullElementsList();
					} else {
						setData(getNext().getData());
						setNext(getNext().getNext());
						if (getNext() != null) {
							((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
						}
					}
				} else {
					getNext().remove(element);
				}

			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>(null, null, this));
				setPrevious(new RecursiveDoubleLinkedListImpl<T>(null, this, null));
			} else {
				RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>(getData(), getNext(), this);
				setData(element);
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(aux);
				setNext(aux);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {

		} else {
			if (getPrevious().isEmpty() && getNext().isEmpty()) {
				nullElementsList();
			} else {
				setData(getNext().getData());
				setNext(getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {

		} else {
			if (getNext().isEmpty()) {
				if (getPrevious().isEmpty()) {
					nullElementsList();
				} else {
					getPrevious().setNext(getNext());
					((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(getPrevious());
				}
			} else {
				((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
			}
		}
	}

	private void nullElementsList() {
		setData(null);
		setNext(null);
		setPrevious(null);
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
