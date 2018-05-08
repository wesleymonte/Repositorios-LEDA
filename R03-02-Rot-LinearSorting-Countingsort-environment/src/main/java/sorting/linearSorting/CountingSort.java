package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && array != null) {
			Integer[] output = copiaArray(array);
			
			int maximo = max(array, leftIndex, rightIndex);
			
			Integer[] count = new Integer[maximo + 1];
			
			// INICIALIZA O COUNT
			for(int i = 0; i < count.length; i++) {
				count[i] = 0;
			}
			
			// SOMA +1 NO INDICE QUE É IGUAL AO NUMERO
			for(int i = leftIndex; i <= rightIndex; i++) {
				count[array[i]]++;
			}
			
			// SOMA DO NUMERO COM SEU ANTERIOR
			for(int j = 1; j <= maximo; j++) {
				count[j] += count[j - 1];
			}
			
			//POSICIONA O INTEIRO NO LOCAL CORRETO
			for(int k = leftIndex; k <= rightIndex; k++) {
				int indiceCorreto = --count[array[k]];
				output[indiceCorreto] = array[k];
			}
			
			
			for(int l = leftIndex; l <= rightIndex; l++) {
				array[l] = output[l];
			}
			
		}
	}
	
	private int max(Integer[] array, int leftIndex, int rightIndex) {
		int maximo = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] > maximo) {
				maximo = array[i];
			}
		}
		return maximo;
	}
	
	private Integer[] copiaArray(Integer[] array) {
		Integer[] copia = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			copia[i] = array[i];
		}
		return copia;
	}

}
