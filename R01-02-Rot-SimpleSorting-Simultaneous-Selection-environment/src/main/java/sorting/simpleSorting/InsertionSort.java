package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	// LISTA = [5,4,3,2,1]
	// LISTA = [4,5,3,2,1]
	// LISTA = [4,3,5,2,1]
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			int j = i - 1;
			while (j >= 0 && array[j + 1].compareTo(array[j]) < 0) {
				Util.swap(array, j + 1, j);
				j--;
			}
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
		InsertionSort<Integer> is = new InsertionSort<>();
		Integer[] array = { 5, 3, 6, 85, 63, 21 };
		Integer[] arrayGerado = geradorInteiros(100);
		System.out.println(listar(array));
		System.out.println(listar(arrayGerado));
		is.sort(array);
		is.sort(arrayGerado);
		System.out.println(listar(array));
		System.out.println(listar(arrayGerado));
	}
}
