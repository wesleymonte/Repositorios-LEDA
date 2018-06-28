package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		int height = 0;
		if (this.isEmpty()) {
			height = -1;
		} else {
			height = heightAux(getRoot());
		}
		return height;
	}

	private int heightAux(BSTNode<T> node) {
		int height = 0;
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				height = 0;
			} else {
				int left = 1 + heightAux(castNode(node.getLeft()));
				int right = 1 + heightAux(castNode(node.getRight()));
				if (left > right) {
					height = left;
				} else {
					height = right;
				}
			}
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> rtn = new BSTNode<T>();
		if (element != null) {
			if (this.isEmpty()) {
				// Se a lista for vazia deve automaticamente retornar um NIL
			} else {
				rtn = search(getRoot(), element);
			}
		}
		return rtn;
	}

	private BSTNode<T> search(BSTNode<T> current, T element) {
		BSTNode<T> rtn = new BSTNode<T>();
		if (current.isEmpty() || current.getData().compareTo(element) == 0) {
			rtn = (castNode(current));
		} else if (current.getData().compareTo(element) > 0) {
			rtn = search(castNode(current.getLeft()), element);
		} else {
			rtn = search(castNode(current.getRight()), element);
		}
		return rtn;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.getRoot().setData(element);
				this.getRoot().setLeft(new BSTNode<T>());
				this.getRoot().setRight(new BSTNode<T>());
			} else {
				insertAux(null, this.getRoot(), element);
			}
		}
	}

	private void insertAux(BSTNode<T> previous, BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(previous);
		} else {
			if (node.getData().compareTo(element) < 0) {
				insertAux(node, castNode(node.getRight()), element);
			} else if (node.getData().compareTo(element) > 0) {
				insertAux(node, castNode(node.getLeft()), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> rtn = null;
		BSTNode<T> aux = getRoot();
		if (!this.isEmpty()) {
			while (!aux.getRight().isEmpty()) {
				aux = castNode(aux.getRight());
			}
			rtn = aux;
		}
		return rtn;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> rtn = null;
		BSTNode<T> aux = getRoot();
		if (!this.isEmpty()) {
			while (!aux.getLeft().isEmpty()) {
				aux = castNode(aux.getLeft());
			}
			rtn = aux;
		}
		return rtn;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> rtn = null;
		if (element != null) {
			BSTNode<T> node = search(getRoot(), element);
			if (!node.isEmpty()) {
				if (!node.getRight().isEmpty()) {
					rtn = treeMinimum(castNode(node.getRight()));
				} else {
					BSTNode<T> parent = castNode(node.getParent());
					while (parent != null && node.equals(parent.getRight())) {
						node = parent;
						parent = castNode(parent.getParent());
					}
					rtn = parent;
				}
			}
		}
		return rtn;
	}

	/*
	 * Pega o menor n� da �rvore
	 */
	private BSTNode<T> treeMinimum(BSTNode<T> node) {
		BSTNode<T> minimum = node;
		while (!minimum.getLeft().isEmpty()) {
			minimum = castNode(minimum.getLeft());
		}
		return minimum;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> rtn = null;
		BSTNode<T> node = search(getRoot(), element);
		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				rtn = treeMaximum(castNode(node.getLeft()));
			} else {
				BSTNode<T> parent = castNode(node.getParent());
				while (parent != null && parent.getLeft().equals(node)) {
					node = parent;
					parent = castNode(parent.getParent());
				}
				rtn = parent;
			}
		}
		return rtn;
	}

	/*
	 * Pega o maior n� da �rvore
	 */
	private BSTNode<T> treeMaximum(BSTNode<T> node) {
		BSTNode<T> maximum = node;
		while (!maximum.getRight().isEmpty()) {
			maximum = castNode(maximum.getRight());
		}
		return maximum;
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (!node.isEmpty()) {
				remove(node);
			}
		}
	}

	private void remove(BSTNode<T> node) {
		if (node.isLeaf()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		} else {
			BSTNode<T> aux = null;
			if (!node.getRight().isEmpty()) {
				aux = treeMinimum(castNode(node.getRight()));
			} else {
				aux = treeMaximum(castNode(node.getLeft()));
			}
			node.setData(aux.getData());
			remove(aux);
		}
	}

	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[size()];
		preOrder(this.getRoot(), array);
		return array;
	}

	private void preOrder(BSTNode<T> node, T[] array) {
		if (!node.isEmpty()) {
			visit(node.getData(), array);
			preOrder(castNode(node.getLeft()), array);
			preOrder(castNode(node.getRight()), array);
		}
	}

	/*
	 * Vai at� a primeira posi��o nula do array e add o elemento.
	 */
	private void visit(T element, T[] array) {
		int count = 0;
		while (count < array.length && array[count] != null) {
			count++;
		}
		if (count < array.length) {
			array[count] = element;
		}
	}

	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[size()];
		order(this.getRoot(), array);
		return array;
	}

	private void order(BSTNode<T> node, T[] array) {
		if (!node.isEmpty()) {
			order(castNode(node.getLeft()), array);
			visit(node.getData(), array);
			order(castNode(node.getRight()), array);
		}
	}

	@Override
	public T[] postOrder() {
		T[] array = (T[]) new Comparable[size()];
		postOrder(getRoot(), array);
		return array;
	}

	private void postOrder(BSTNode<T> node, T[] array) {
		if (!node.isEmpty()) {
			postOrder(castNode(node.getLeft()), array);
			postOrder(castNode(node.getRight()), array);
			visit(node.getData(), array);
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand how
	 * it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}

	private BSTNode<T> castNode(Object node) {
		BSTNode<T> rtn = null;
		if (node instanceof BSTNode<?>) {
			rtn = ((BSTNode<T>) node);
		}
		return rtn;
	}

}
