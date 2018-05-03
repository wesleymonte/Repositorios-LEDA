package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	// 5 3 6 85 63 21
	// 0 1 2 3  4  5
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex)/2;
			
			sort(array, leftIndex, middle);
			sort(array, (middle + 1), rightIndex);
			
			mergeSort(array, leftIndex, middle, rightIndex);
		}

		
		
	}
	
	private void mergeSort(T[] array, int leftIndex, int middle, int rightIndex) {
		
		// 1 2 3 l=1 m=2 r=3
		// 0 1 2 3 4 l=0 m=2 r=4
		// 0 1 2 3 4 5 l=0 m=2 r=5
		int n1 = middle - leftIndex + 1;
		int n2 = rightIndex - middle;
		
		T[] A1 = (T[]) new Comparable[n1];
		T[] A2 = (T[]) new Comparable[n2];
		
        for (int i =0; i < n1; ++i)
            A1[i] = array[leftIndex + i];
		
        for (int j = 0; j < n2; ++j)
            A2[j] = array[middle + 1+ j];
		
		int i = 0;
		int j = 0;
		int k = leftIndex;
		
		while(i < n1 && j < n2) {
			if(A1[i].compareTo(A2[j]) < 0) {
				array[k] = A1[i];
				i++;
			}
			else if(A1[i].compareTo(A2[j]) > 0) {
				array[k] = A2[j];
				j++;
			}
			else {
				array[k] = A1[i];
				i++;
			}
			k++;
		}
		
		while(i < n1) {
			array[k++] = A1[i++];
		}
		
		while(j < n2) {
			array[k++] = A2[j++];
		}
	}
	
	public static String listar(Integer[] array) {
		String string = "";
		for (int i : array) {
			string += Integer.toString(i) + " ";
		}
		return string;
	}
	
	public static Integer[] geradorInteiros(int n) {
		Integer[] inteiros = new Integer[n];
		int cont = n;
		for (int j = 0; j < n; j++) {
			int soma = 0;
			for (int i = 1; i <= (cont * 5); i++) {
				soma += i;
			}
			inteiros[j] = soma;
			cont--;
		}
		return inteiros;
	}
	
	public static void main(String[] args) {
		MergeSort<Integer> ms = new MergeSort<>();
		Integer[] array = { 5, 3, 6, 85, 63, 21 };
		Integer[] arrayGerado = geradorInteiros(100);
		System.out.println(listar(array));
		System.out.println(listar(arrayGerado));
		ms.sort(array);
		ms.sort(arrayGerado);
		System.out.println(listar(array));
		System.out.println(listar(arrayGerado));
	}
}
