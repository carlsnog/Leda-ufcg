package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if ((array.length > 1) && (leftIndex >= 0) && (leftIndex < array.length) 
		&& (rightIndex >= 0) && (rightIndex < array.length) &&
		(leftIndex < rightIndex)) {
			int pivot = partition(array, leftIndex, rightIndex);

			sort(array, leftIndex,pivot-1);
			sort(array, pivot+1, rightIndex);
		}
	}

	public int partition(T[] array, int left, int right) {
		int init = left +1;
		int fim = right;
		T pivot = array[left];

		while (init <= fim) {
			
			// vai passando pelos elementos menores(a partir do inicio) que o pivot até achar um maior
			while (init <= fim && pivot.compareTo(array[init]) >= 0) {
				init++;
			}

			// vai passando pelos elementos maiores (vem do fim) que o pivot até achar um menor
			while (init <= fim && pivot.compareTo(array[fim]) < 0) {
				fim--;
			}
			// troca os de posição os elementos, ao fim da indentificação dos menores, colocando todos os menores que o pivot na sua frente
			if (init < fim) {
				Util.swap(array, init, fim);
			}

		}
		// troca o ultimo maior indentificado pelo pivot, que estava na posição inicial
		Util.swap(array, left, fim);
		return fim;

	}
}
