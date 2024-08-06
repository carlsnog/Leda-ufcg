package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			Integer max = max(array, leftIndex, rightIndex);
			Integer min = min(array, leftIndex, rightIndex);
			Integer[] freq = frequence(array, leftIndex, rightIndex, max, min);
			Integer[] ord =  new Integer[rightIndex-leftIndex+1];
			// Ajusta as posições conforme a frequência
			for (int i = rightIndex; i>= leftIndex; i--) {
				ord[freq[array[i] -min] -1] = array[i];
				freq[array[i] -min] -= 1;
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

	public Integer min(Integer[] array, int leftIndex, int rightIndex) {
		Integer min = leftIndex;
		for (int i = leftIndex; i<=rightIndex; i++) {
			if (array[i].compareTo(array[min]) < 0) {
				min = i;
			}
		}
		return array[min];
	}

	public void replace(Integer[] origem, Integer[] destino, int leftIndex, int rightIndex) {
		int i = 0;
		for (int j = leftIndex; j <= rightIndex; j++) {
			destino[j] = origem[i++];
		}
	} 

	public Integer[] frequence(Integer[] array, int leftIndex, int rightIndex, int max, int min) {
		Integer[] freqIntegers = new Integer[max-min+1];
		for (int k = 0; k<freqIntegers.length;k++) {
			freqIntegers[k] = 0;
		}
		// frequência normal
		for (int i = leftIndex; i<=rightIndex; i++) {
			freqIntegers[array[i]-min] += 1;
		}
		//frequência acumulada
		for (int j = 1; j<freqIntegers.length; j++) {
			freqIntegers[j] += freqIntegers[j-1];
		}
		return freqIntegers;
	}
}
