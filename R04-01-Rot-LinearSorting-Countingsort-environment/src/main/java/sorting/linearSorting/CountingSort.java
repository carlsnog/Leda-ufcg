package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			Integer max = max(array, leftIndex, rightIndex);
			Integer[] freq = frequence(array, leftIndex, rightIndex, max);
			Integer[] ord =  new Integer[rightIndex-leftIndex+1];
			// Ajusta as posições conforme a frequência
			for (int i = rightIndex; i>= leftIndex; i--) {
				ord[freq[array[i] -1] -1] = array[i];
				freq[array[i] -1] -= 1;
			}
			replace(ord, array, leftIndex, rightIndex);
		}		
	}

	public Integer max(Integer[] array, int leftIndex, int rightIndex) {
		Integer max = leftIndex;
		for (int i = leftIndex; i<=rightIndex; i++) {
			if (array[i].compareTo(array[max]) > 0) {
				max = i;
			}
		}
		return array[max];
	}

	public void replace(Integer[] origem, Integer[] destino, int leftIndex, int rightIndex) {
		int i = 0;
		for (int j = leftIndex; j <= rightIndex; j++) {
			destino[j] = origem[i++];
		}
	}

	public Integer[] frequence(Integer[] array, int leftIndex, int rightIndex, int max) {
		Integer[] freqIntegers = new Integer[max];
		for (int k = 0; k<freqIntegers.length;k++) {
			freqIntegers[k] = 0;
		}
		// frequência normal
		for (int i = leftIndex; i<=rightIndex; i++) {
			freqIntegers[array[i]-1] += 1;
		}
		//frequência acumulada
		for (int j = 1; j<freqIntegers.length; j++) {
			freqIntegers[j] += freqIntegers[j-1];
		}
		return freqIntegers;
	}
}
