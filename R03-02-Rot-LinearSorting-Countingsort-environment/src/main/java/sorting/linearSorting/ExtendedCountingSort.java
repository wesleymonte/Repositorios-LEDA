package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && array != null) {
			Integer[] output = copiaArray(array);
			
			int maximo = max(array, leftIndex, rightIndex);
			int minimo = min(array, leftIndex, rightIndex);
			int dif = maximo - minimo;
			
			Integer[] count = new Integer[dif + 1];
			
			// INICIALIZA O COUNT
			for(int i = 0; i < count.length; i++) {
				count[i] = 0;
			}
			
			// SOMA +1 NO INDICE QUE É IGUAL AO NUMERO
			for(int i = leftIndex; i <= rightIndex; i++) {
				int indice;
				if(minimo < 0) {
					indice = array[i] + mod(minimo);
				}
				else {
					indice = array[i] - mod(minimo);
				}
				count[indice]++;
				
			}
			
			// SOMA DO NUMERO COM SEU ANTERIOR
			for(int j = 1; j < count.length; j++) {
				count[j] += count[j - 1];
			}
			
			//POSICIONA O INTEIRO NO LOCAL CORRETO
			for(int k = leftIndex; k <= rightIndex; k++) {
				int indiceCorreto;
				if(minimo < 0) {
					indiceCorreto = --count[array[k] + mod(minimo)];
				}
				else {
					indiceCorreto = --count[array[k] - mod(minimo)];
				}
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
	
	private int min(Integer[] array, int leftIndex, int rightIndex) {
		int minimo = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] < minimo) {
				minimo = array[i];
			}
		}
		return minimo;
	}
	
	private int mod(int n) {
		if(n < 0) {
			return (-1) * n;
		}
		else {
			return n;
		}
	}
	
	private Integer[] copiaArray(Integer[] array) {
		Integer[] copia = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			copia[i] = array[i];
		}
		return copia;
	}

}
