package sorting.variationsOfSelectionsort;

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
		if ((leftIndex >= 0 && leftIndex < array.length) && 
		(rightIndex >= 0 && rightIndex < array.length) && (array.length > 1)) {
			
			if (leftIndex < rightIndex) {
				int min_ind = findSmallest(array, leftIndex, rightIndex, leftIndex);
				Util.swap(array, leftIndex, min_ind);
				sort(array, leftIndex+1, rightIndex);
			}
		}
	}

	public int findSmallest(T[] array, int lf, int rg, int min) {
		int result = min;
		if (lf <= rg) {
			if (array[min].compareTo(array[lf]) > 0) {
				min = lf;
			}
			result = findSmallest(array, lf+1, rg, min);
		}
		return result;

	}

}
