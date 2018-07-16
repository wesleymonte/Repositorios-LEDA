package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	
	@Override
	public void insert(int key, T newValue, int height) {
		if(height > maxHeight) {
			throw new RuntimeException();
		} else if(newValue != null){
			SkipListNode<T>[] update = new SkipListNode[this.maxHeight];
			SkipListNode<T> current = this.root;
			for(int i = this.maxHeight - 1; i >= 0; i--) {
				while(current.getForward(i).getKey() < key) {
					current = current.getForward(i);
				}
				update[i] = current;
			}
			
			current = current.getForward(0);
				
			if(current.getKey() == key) {
				current.setValue(newValue);
			} else {
				current = new SkipListNode<T>(key, height, newValue);
				for(int i = 0; i < height; i++) {
					current.getForward()[i] = update[i].forward[i];
					update[i].forward[i] = current;
				}
			}
		}
	}

	@Override
	public void remove(int key) {
		SkipListNode<T>[] update = new SkipListNode[this.maxHeight];
		SkipListNode<T> current = this.root;
		for(int i = maxHeight - 1; i >= 0; i--) {
			while(current.getForward(i).getKey() < key) {
				current = current.getForward(i);
			}
			update[i] = current;
		}
		current = current.getForward(0);
		if(current.getKey() == key) {
			for(int i = 0; i < height(); i++) {
				if(!(update[i].forward[i].equals(current))) {
					break;
				}
				update[i].forward[i] = current.forward[i];
			}
		}
	}

	@Override
	public int height() {
		int height = 0;
		if(!(this.size() == 0)) {
			SkipListNode<T> current = this.root.getForward(0);
			while(current.getKey() != Integer.MAX_VALUE) {
				if(current.getForward().length > height) {
					height = current.getForward().length;
				}
				current = current.getForward(0);
			}
		}
		return height;
	}

	@Override
	public SkipListNode<T> search(int key) {
		SkipListNode<T> rtn = null;
		SkipListNode<T> current = this.root;
		for(int i = maxHeight - 1; i >= 0; i--) {
			while(current.getForward(i).getKey() < key) {
				current = current.getForward(i);
			}
		}
		current = current.getForward(0);
		if(current.getKey() == key) {
			rtn = current;
		}
		return rtn;
		
	}

	@Override
	public int size() {
		int size = 0;
		SkipListNode<T> current = this.root.getForward(0);
		while(current.getKey() != Integer.MAX_VALUE){
			size++;
			current = current.getForward(0);
		}
		return size;
		
	}

	@Override
	public SkipListNode<T>[] toArray() {
		int sizeArray = size() + 2;
		SkipListNode<T>[] array = new SkipListNode[sizeArray];
		SkipListNode<T> current = this.root;
		for(int i = 0; i < sizeArray; i++) {
			array[i] = current;
			current = current.getForward(0);
		}
		return array;
		
	}

}
