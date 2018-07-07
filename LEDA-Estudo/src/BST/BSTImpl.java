package BST;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {
	
	private BSTNode<T> root;
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	@Override
	public BSTNode<T> getRoot() {
		return root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BSTNode<T> search(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		return null;
	}

}
