package orderStatistic;

import java.util.Arrays;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim poraplciar sucessivas selecoes.
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		return null;
		
	}
	
	public T SelectionSort(T[] array, int leftIndex, int rightIndex, int indexRef) {
		int menor = maior(array, leftIndex, rightIndex);
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i].compareTo(array[indexRef]) > 0 && array[i].compareTo(array[menor]) < 0) {
				menor = i;
			}
		}
		return array[menor];
		
	}
	
	private int maior(T[] array, int leftIndex, int rightIndex) {
		int maior = leftIndex;
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i].compareTo(array[maior]) > 0) {
				maior = i;
			}
		}
		return maior;
	}
	
	public static void main(String[] args) {
		Integer[] i1 = new Integer[] {0,5,9,9,3,7,90,55,20,74,12};
		Integer[] i2 = new Integer[] {0,5,9,9,3,7,90,55,20,74,12};
		Arrays.sort(i2);
		System.out.println(Arrays.toString(i2));
		OrderStatisticsSelectionImpl<Integer> oss = new OrderStatisticsSelectionImpl<>();
		System.out.println(oss.SelectionSort(i1, 0, i1.length - 1, 2));
	}
	
	

}
