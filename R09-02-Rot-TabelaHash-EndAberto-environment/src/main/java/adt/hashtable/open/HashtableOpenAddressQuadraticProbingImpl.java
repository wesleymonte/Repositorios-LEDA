package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size, HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && !this.isFull() && !this.contains(element)) {
			insertAux(element, 0);
		}
	}

	private void insertAux(T element, int probe) {
		int index = calculateHash(element, probe);

		if (this.table[index] != null && this.table[index] != deletedElement) {
			this.insertAux(element, probe + 1);
			this.COLLISIONS++;
		} else {
			this.table[index] = element;
			this.elements++;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			removeAux(element, 0);
		}
	}

	private void removeAux(T element, int probe) {
		int index = calculateHash(element, probe);

		if (table[index] == null) {
			// PERCORREU TODA TABLE E NÃO ENCONTROU O ELEMENTO
		} else {
			if (element.equals(table[index])) {
				table[index] = deletedElement;
				this.elements--;
			} else {
				removeAux(element, probe + 1);
			}
		}
	}

	@Override
	public T search(T element) {
		T rtn = null;
		if (element != null && !isEmpty()) {
			rtn = searchAux(element, 0);
		}
		return rtn;
	}

	@SuppressWarnings("unchecked")
	private T searchAux(T element, int probe) {
		T rtn = null;
		int index = calculateHash(element, probe);

		if (table[index] == null || probe > this.capacity()) {

		} else {
			if (element.equals(table[index])) {
				rtn = ((T) table[index]);
			} else {
				rtn = searchAux(element, probe + 1);
			}
		}
		return rtn;

	}

	@Override
	public int indexOf(T element) {
		int indexElement = -1;
		if (element != null) {
			int probe = 0;
			int index = calculateHash(element, probe);

			while (this.table[index] != null && !this.table[index].equals(element) && probe != this.capacity()) {
				index = calculateHash(element, ++probe);
			}

			if (this.table[index] != null && table[index].equals(element)) {
				indexElement = index;
			}
		}
		return indexElement;
	}

	private int calculateHash(T element, int probe) {
		int temp = -1;
		if (hashFunction instanceof HashFunctionQuadraticProbing<?>) {
			temp = AbsoluteValue(((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probe));
		}
		return temp;

	}
	


	private int AbsoluteValue(int value) {
		int absolute = value;
		if (value < 0) {
			absolute = absolute * -1;
		}
		return absolute;
	}
	

	@SuppressWarnings("unchecked")
	private boolean contains(T element) {
		boolean contains = false;

		for (Object t : table) {
			if (t instanceof Storable) {
				if (t != null && ((T) t).equals(element)) {
					contains = true;
				}
			}
		}

		return contains;
	}
}
