package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array, 0, array.length-1);
		return search(array, x, 0, array.length-1);
	}

	public Integer search(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		Integer result = null;
		if (leftIndex <= rightIndex) {
			int meio = (rightIndex + leftIndex)/2;
			if (array[meio].compareTo(x) <=0) {
				result = array[meio];
				Integer aux = search(array, x, meio+1, rightIndex);
				if (aux != null) {result = aux;}
			}
			else {
				result = search(array, x, leftIndex, meio-1);
			}
		}
		return result;
	}

	public void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex <= rightIndex) {
			int indexPivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, indexPivot-1);
			quickSort(array, indexPivot+1, rightIndex);
		}
	}

	public int partition(Integer[] array, int leftIndex, int rightIndex) {
		int ini = leftIndex +1;
		int fim = rightIndex;
		Integer pivot = array[leftIndex];

		while (leftIndex <= rightIndex) {
			while (leftIndex <= rightIndex && pivot.compareTo(array[ini]) >= 0) {
				ini++;
			}
			while (leftIndex <= rightIndex && pivot.compareTo(array[fim]) < 0){
				fim--;
			}
			if (ini < fim) {
				Util.swap(array, ini, fim);
			}
		}
		Util.swap(array, leftIndex, fim);
		return fim;
	}

}
