package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o maior sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 3 > 2),
 * essa heap deixa os elementos maiores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. Dessa
 * forma, dependendo do comparator, a heap pode funcionar como uma max-heap ou
 * min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é mudar
	 * apenas o comparator e mandar reordenar a heap usando esse comparator. Assim
	 * os metodos da heap não precisam saber se vai funcionar como max-heap ou
	 * min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma min-heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento indexado
	 * pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento indexado
	 * pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (T elem : this.heap) {
			if (elem != null) {
				resp.add(elem);
			}
		}
		return (T[]) resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode ser
	 * a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
	 * (comparados usando o comparator) elementos na parte de cima da heap.
	 */
	private void heapify(int position) {
		if (validateIndex(position)) {
			int highest = position;
			int left = left(position);
			int right = right(position);

			if (validateIndex(left) && comparator.compare(heap[highest], heap[left]) < 0) {
				highest = left;
			}

			if (validateIndex(right) && comparator.compare(heap[highest], heap[right]) < 0) {
				highest = right;
			}

			if (highest != position) {
				Util.swap(heap, position, highest);
				heapify(highest);
			}
		}
	}

	private boolean validateIndex(int index) {
		boolean valid = false;
		if (index < this.size() && index >= 0) {
			valid = true;
		}
		return valid;
	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		// /////////////////////////////////////////////////////////////////
		if (element != null) {
			this.heap[size()] = element;
			reorganiza(size());
			index++;
		}

	}

	private void reorganiza(int child) {
		int parent = parent(child);
		if (parent >= 0 && comparator.compare(heap[parent], heap[child]) < 0) {
			Util.swap(heap, parent, child);
			reorganiza(parent);
		}
	}

	@Override
	public void buildHeap(T[] array) {
		if (array != null) {
			clear();
			int i = 0;
			while (i < array.length) {
				insert(array[i++]);
			}
		}
	}

	@Override
	public T extractRootElement() {
		T root = rootElement();
		if (!isEmpty()) {
			Util.swap(heap, 0, index);
			heap[index--] = null;
			heapify(0);
		}
		return root;
	}

	@Override
	public T rootElement() {
		T root = null;
		if (!isEmpty()) {
			root = this.heap[0];
		}
		return root;
	}

	@Override
	public T[] heapsort(T[] array) {
		T[] SortedArray = null;
		if (array != null) {
			clear();
			for (T e : array) {
				insert(e);
			}
			int size = size();
			SortedArray = (T[]) new Comparable[size];

			if (isMaxHeap()) {
				size--;
				while (size >= 0)
					SortedArray[size--] = extractRootElement();
			} else {
				int i = 0;
				while (i < size) {
					SortedArray[i++] = extractRootElement();
				}
			}
		}
		return SortedArray;
	}

	private boolean isMaxHeap() {
		boolean ismax = true;
		int index = 0;

		while (index < size()) {
			if (heap[index].compareTo(rootElement()) > 0) {
				ismax = false;
				break;
			}
			index++;
		}
		return ismax;
	}

	private void clear() {
		int size = index;
		while (size >= 0) {
			heap[size--] = null;
		}
		index = -1;
	}

	@Override
	public int size() {
		return index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
