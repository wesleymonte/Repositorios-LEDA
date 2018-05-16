package sorting.variationsOfSelectionsort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int menor = leftIndex;
			for(int j = leftIndex + 1; j <= rightIndex; j++) {
				if(array[j].compareTo(array[menor]) < 0) {
					menor = j;
				}
			}
			Util.swap(array, leftIndex, menor);
			sort(array, leftIndex + 1, rightIndex);
		}
	}
	
	public static void main(String[] args) {
		Integer[] i1 = {5, 9, 6, 10, 69, 32, 21, 53, 22, 9};
		RecursiveSelectionSort<Integer> rss = new RecursiveSelectionSort<>();
		rss.sort(i1, 1, 4);
		System.out.println(Arrays.toString(i1));
	}

}
