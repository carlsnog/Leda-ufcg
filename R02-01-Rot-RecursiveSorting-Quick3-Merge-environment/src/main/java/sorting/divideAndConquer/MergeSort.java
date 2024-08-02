package sorting.divideAndConquer;

import sorting.AbstractSorting;
import java.util.ArrayList;
import java.util.List;
/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if ((array.length > 1) && (leftIndex >= 0) && (leftIndex < array.length) 
		&& (rightIndex >= 0) && (rightIndex < array.length) &&
		(leftIndex < rightIndex)) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex+1, rightIndex);

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
