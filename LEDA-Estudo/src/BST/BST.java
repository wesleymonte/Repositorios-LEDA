package BST;

public interface BST<T extends Comparable<T>> {
	
	public BSTNode<T> getRoot();
	
	public boolean isEmpty();
	
	public int height();
	
	public BSTNode<T> search(T element);
	
	public void insert(T value);
	
	public void remove(T key);
	
	public T[] preOrder();
	
	public T[] order();
	
	public T[] postOrder();
	
	public int size();
	
	public BSTNode<T> maximum();
	
	public BSTNode<T> minimum();
	
	public BSTNode<T> sucessor(T element);
	
	public BSTNode<T> predecessor(T element);
	
}
