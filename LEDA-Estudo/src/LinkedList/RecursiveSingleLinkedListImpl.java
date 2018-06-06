package LinkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {
	
	protected T data;
	protected RecursiveSingleLinkedListImpl next;
	
	@Override
	public boolean isEmpty() {
		boolean empty;
		if(data == null) {
			empty = true;
		}
		else {
			empty = false;
		}
		return empty;
	}

	@Override
	public int size() {
		int count = 0;
		if(isEmpty()) {
			count += 1;
		}
		else {
			count += 1 + next.size();
		}
		return count;
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
