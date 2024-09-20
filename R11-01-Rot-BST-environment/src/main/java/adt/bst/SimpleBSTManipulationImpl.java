package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			result = equalsRecursive((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return result;
	}

	private boolean equalsRecursive(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = node1.equals(node2);
		if (result && !node1.isEmpty() && !node2.isEmpty()) {
			result = equalsRecursive((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) 
				&&  equalsRecursive((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight()) ;
		}
		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			result = isSimilarRecursive((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return result;
	}

	private boolean isSimilarRecursive(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = node1.isEmpty() == node2.isEmpty();
		if (!node1.isEmpty() && !node2.isEmpty()) {
			result = isSimilarRecursive((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) 
					&& isSimilarRecursive((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
		}
		return result;
	}

	private int count;

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T result = null;
		if (k >= 1 && tree != null) {
			this.count = 0;
			result = this.orderStatisticRecursive((BSTNode<T>) tree.getRoot(), k);
		}
		return result;
	}

	private T orderStatisticRecursive(BSTNode<T> node, int k) {
		T result = null;
		if (!node.isEmpty()) {
			result = orderStatisticRecursive((BSTNode<T>) node.getLeft(), k);
			this.count++;
			if (count == k) {
				result = node.getData();
			}
			if (result == null) {
				result = orderStatisticRecursive((BSTNode<T>) node.getRight(), k);
			}
		}
		return result;
	}

}
