package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if ((array.length > 1) && (leftIndex >= 0) && (leftIndex < array.length) 
		&& (rightIndex >= 0) && (rightIndex < array.length) &&
		(leftIndex < rightIndex)) {
			MERGESORT_APPLICATIONS = 0;
			INSERTIONSORT_APPLICATIONS = 0;

			if ((rightIndex - leftIndex) <= SIZE_LIMIT) {
				insertionsort(array, leftIndex, rightIndex);
				INSERTIONSORT_APPLICATIONS++;
			}
			else {
				mergeSort(array, leftIndex, rightIndex);
				MERGESORT_APPLICATIONS++;

			}
		}
	}

	public void insertionsort(T[] array, int leftIndex, int rightIndex) {
		if ((leftIndex >= 0 && leftIndex < array.length) && (rightIndex >= 0 && rightIndex < array.length) && (array.length > 1)) {
			for (int i = leftIndex + 1; i <= rightIndex; i ++) { 
				int j = i;
				while (j > leftIndex && array[j].compareTo(array[j-1]) < 0) {
					Util.swap(array, j, j-1);
					j-=1;
				}
			}
		}
	} 

	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if ((array.length > 1) && (leftIndex >= 0) && (leftIndex < array.length) 
		&& (rightIndex >= 0) && (rightIndex < array.length) &&
		(leftIndex < rightIndex)) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, middleIndex);
			mergeSort(array, middleIndex+1, rightIndex);

			merge(array, leftIndex, middleIndex, rightIndex);
		}
	}

	public void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
        List<T> part = new ArrayList<>();
        
        for (int j = leftIndex; j <= rightIndex; j++) {
            part.add(array[j]);
        }

		int init = leftIndex;
		int mid = middleIndex + 1;
		int pas = leftIndex;

 		while (init <= middleIndex && mid <= rightIndex) {
            if (part.get(init - leftIndex).compareTo(part.get(mid - leftIndex)) <= 0) {
                array[pas] = part.get(init - leftIndex);
                init++;
            } else {
                array[pas] = part.get(mid - leftIndex);
                mid++;
            }
            pas++;
        }

        while (init <= middleIndex) {
            array[pas] = part.get(init - leftIndex);
            init++;
            pas++;
        }
	}
}
