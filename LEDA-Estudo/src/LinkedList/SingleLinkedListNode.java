package LinkedList;

public class SingleLinkedListNode<T> {
	
	protected T data;
	protected SingleLinkedListNode<T> next;
	
	public SingleLinkedListNode() {
		
	}
	
	public SingleLinkedListNode(T data, SingleLinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public boolean isNIL() {
		return (this.data == null);
	}

}
