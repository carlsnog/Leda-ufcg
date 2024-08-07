package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return search(array, x, 0, array.length-1);
	}

	public Integer search(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		Integer result = null;
		if (leftIndex < rightIndex) {
			int meio = (rightIndex + leftIndex)/2;
			if (array[meio].equals(x)) {
				result = array[meio];
				Integer aux = search(array, x, meio+1, rightIndex);
				if (aux != null) {result = aux;}
			}
			else if (array[meio].compareTo(x) > 0) {
				search(array, x, leftIndex, meio-1);
			}
			else {
			}
			 
		}
		return result;
	}

}
