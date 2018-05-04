package sorting.simpleSorting;


import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for(int last = rightIndex; last > 0; last--) {
			for(int i = 0; i < last; i++) {
				if(array[i].compareTo(array[i + 1]) > 0) {
					Util.swap(array, i,  i + 1);
				}
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
	
	public static String listar(int[] array) {
		String string = "";
		for (int i : array) {
			string += Integer.toString(i) + " ";
		}
		return string;
	}
	
	public static void main(String[] args) {
		BubbleSort<Integer> bs = new BubbleSort<>();
		Integer[] array = {5,3,6,85,63,21};
		bs.sort(array);
		System.out.println(listar(array));
		int[] teste = new int[5];
		System.out.println(listar(teste));
	}
}
