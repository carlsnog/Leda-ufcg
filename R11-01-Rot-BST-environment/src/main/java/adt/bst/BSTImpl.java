package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> search(T element) {
		return searchRecursive(this.getRoot(), element);
	}

	private BSTNode<T> searchRecursive(BSTNode<T> node,T element) {
		BSTNode<T> result = new BSTNode<>();
		if (!node.isEmpty()) {
			if (node.getData().equals(element)) {
				result = node;
			} else if (node.getData().compareTo(element) > 0) {
				result = searchRecursive((BSTNode<T>) node.getLeft(), element);
			} else {
				result = searchRecursive((BSTNode<T>) node.getRight(), element);
			}
		}
		return result;
	}


	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = maximumRecursive(this.getRoot());
		}
		return result;
	}

	private BSTNode<T> maximumRecursive(BSTNode<T> node) {
		BSTNode<T> value = node;
		if (!node.getRight().isEmpty()) {
			value = maximumRecursive((BSTNode<T>) node.getRight());
		}
		return value;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = minimumRecursive(this.getRoot());
		}
		return result;
	}

	private BSTNode<T> minimumRecursive(BSTNode<T> node) {
		BSTNode<T> result = node;
		if (!node.getLeft().isEmpty()) {
			result = minimumRecursive((BSTNode<T>) node.getLeft());
		}
		return result;
	}


	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> result = null;

		if (!node.isEmpty()) {
			BSTNode<T> right = (BSTNode<T>) node.getRight();
			if (!right.isEmpty()) {
				result = minimumRecursive(right);
			}
			else {
				result = sucessorRecursive(element, (BSTNode<T>) node.getParent());
			}
		}
		return result;
	}

	private BSTNode<T> sucessorRecursive(T element, BSTNode<T> node) {
		BSTNode<T> result;
		if (node == null || node.getData().compareTo(element) > 0) {
			result = node;
		} else {
			result = sucessorRecursive(element, (BSTNode<T>) node.getParent());
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> result = null;

		if (!node.isEmpty()) {
			BSTNode<T> left = (BSTNode<T>) node.getLeft();
			if (!left.isEmpty()) {
				result = maximumRecursive(left);
			} else {
				result = predecessorRecursive(element, (BSTNode<T>) node.getParent());
			}
		}
		return result;
	}

	private BSTNode<T> predecessorRecursive(T element, BSTNode<T> node) {
		BSTNode<T> result;
		if (node == null || node.getData().compareTo(element) < 0) {
			result = node;
		} else {
			result = predecessorRecursive(element, (BSTNode<T>) node.getParent());
		}
		return result;
	}


	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
