package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	private void balancedInsert(Integer[] array) {
		balancedInsertRecursive(array, 0, array.length - 1);
	}
	
	private void balancedInsertRecursive(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex <= rightIndex) {
			int mid = (leftIndex + rightIndex) / 2; 
			this.insert(array[mid]); 
			balancedInsertRecursive(array, leftIndex, mid - 1); 
			balancedInsertRecursive(array, mid + 1, rightIndex);   
		}
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer result = null;
		if (array != null && array.length != 0) {
			this.balancedInsert(array);
			result = floorRecursive(this.getRoot(), numero, null);
		}
		return result;
	}

	private Integer floorRecursive(BSTNode<Integer> node, double numero, Integer floor) {
		if (!node.isEmpty()) {
			if (numero < node.getData()) {
				floor = floorRecursive((BSTNode<Integer>) node.getLeft(), numero, floor);
			} else if (numero > node.getData()) {
				floor = floorRecursive((BSTNode<Integer>)node.getRight(), numero, node.getData());
			} else {
				floor = node.getData();
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		if (array != null && array.length > 0) {
			this.balancedInsert(array);
			ceil = this.ceilRecursive(this.root, numero, null);
		}
		return ceil;
	}

	private Integer ceilRecursive(BSTNode<Integer> node, double numero, Integer ceil) {
		if (!node.isEmpty()) {
			if (numero < node.getData()) {
				ceil = this.ceilRecursive((BSTNode<Integer>) node.getLeft(), numero, node.getData());
			} else if (numero > node.getData()) {
				ceil = this.ceilRecursive((BSTNode<Integer>) node.getRight(), numero, ceil);
			} else {
				ceil = node.getData();
			}
		}
		return ceil;
	}

}
