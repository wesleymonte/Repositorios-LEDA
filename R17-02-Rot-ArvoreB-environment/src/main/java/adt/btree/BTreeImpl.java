package adt.btree;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

	protected BNode<T> root;
	protected int order;

	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}

	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BNode<T> node) {
		int height = 0;
		if(this.isEmpty()) {
			height = -1;
		} else {
			if(!node.isLeaf()) {
				height = 1 + height(node.getChildren().get(0));
			}
		}
		return height;
	}

	private int numberOfNodes() {
		int numberOfNodes = 0;
		if (!isEmpty()) {
			numberOfNodes = numberOfNodes(getRoot());
		}
		return numberOfNodes;
	}

	private int numberOfNodes(BNode<T> node) {
		int num = 1;
		if (!node.isLeaf()) {
			for (BNode<T> children : node.getChildren()) {
				num += numberOfNodes(children);
			}
		}
		return num;
	}

	@Override
	public BNode<T>[] depthLeftOrder() {
		BNode<T>[] array = new BNode[numberOfNodes()];
		depthLeftOrder(getRoot(), array);
		return array;
	}

	private void depthLeftOrder(BNode<T> node, BNode<T>[] array) {
		addInArray(array, node);
		for (BNode<T> children : node.getChildren()) {
			depthLeftOrder(children, array);
		}
	}

	private void addInArray(BNode<T>[] array, BNode<T> node) {
		int i = 0;
		while (i < array.length && array[i] != null) {
			i++;
		}
		if (i < array.length) {
			array[i] = node;
		}
	}

	@Override
	public int size() {
		return size(this.getRoot());
	}

	private int size(BNode<T> node) {
		int size = sizeOfNode(node);

		for (BNode<T> children : node.getChildren()) {
			size += size(children);
		}

		return size;
	}

	private int sizeOfNode(BNode<T> node) {
		return node.getElements().size();
	}

	@Override
	public BNodePosition<T> search(T element) {
		return search(getRoot(), element);
	}

	public BNodePosition<T> search(BNode<T> node, T element) {
		int i = 0;
		BNodePosition<T> rtn = new BNodePosition<T>(null, -1);
		while (i < node.getElements().size() && node.getElementAt(i).compareTo(element) < 0) {
			i++;
		}
		if(i < node.getElements().size() && node.getElementAt(i).compareTo(element) == 0) {
			rtn = new BNodePosition<T>(node, i + 1);
		} else if(!node.isLeaf()) {
			rtn = search(node.getChildren().get(i), element);
		}
		return rtn;
	}

	@Override
	public void insert(T element) {
		insert(getRoot(), element);

	}

	private void insert(BNode<T> node, T element) {
		if (node.isLeaf()) {
			verifyAdd(node, element);
		} else {
			int i = 0;
			while (i < node.getElements().size() && node.getElementAt(i).compareTo(element) < 0) {
				i++;
			}
			if (i < node.getElements().size()) {
				insert(node.getChildren().get(i + 1), element);
			} else {
				insert(node.getChildren().get(i), element);
			}
		}
	}

	private void verifyAdd(BNode<T> node, T element) {
		if (node.isFull()) {
			if (node.getParent() == null) {
				node.setParent(new BNode<T>(node.getOrder()));
				node.getParent().addChild(0, node);
				node.addElement(element);
				T elementMediana = node.getElements().remove(node.indexOfMediana());
				node.split();
				this.root = node.getParent();
				verifyAdd(node.getParent(), elementMediana);
			} else {
				node.addElement(element);
				T elementMediana = node.getElements().remove(node.indexOfMediana());
				node.split();
				verifyAdd(node.getParent(), elementMediana);
			}
		} else {
			node.addElement(element);
		}
	}

	private void split(BNode<T> node) {
		node.split();
	}

	private void promote(BNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	// NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public BNode<T> minimum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public void remove(T element) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

}
