package adt.bst;

import java.util.*;

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
		return heightRecursive(this.getRoot());
	}

	private int heightRecursive(BSTNode<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = Math.max(heightRecursive((BSTNode<T>)node.getLeft()), heightRecursive((BSTNode<T>)node.getRight()))+1;
		}
		return result;
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
		if (this.isEmpty()) {
			this.root = (BSTNode<T>) new BSTNode.Builder<T>()
										.data(element)
										.left(new BSTNode<T>())
										.right(new BSTNode<T>())
										.build();
			this.getRoot().getLeft().setParent(getRoot());
			this.getRoot().getRight().setParent(getRoot());
		} else {
			insertRecursive(getRoot(), element);
		}
	}

	private void insertRecursive(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (node.getData().compareTo(element) > 0) {
				insertRecursive((BSTNode<T>) node.getLeft(), element);
			} else if (node.getData().compareTo(element) < 0) {
				insertRecursive((BSTNode<T>) node.getRight(), element);
			}
		}
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
		BSTNode<T> node = search(element);
		remove(node);
	}

	private boolean hasOnlyChild(BSTNode<T> node) {
		return ((node.getLeft().isEmpty() || node.getRight().isEmpty()) && 
				!(node.getLeft().isEmpty() && node.getRight().isEmpty()));
	}
	
	private void remove(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {	
			if (node.isLeaf()) {
				node.setData(null);
			} else if (hasOnlyChild(node)) {
				if (node.getParent() != null) {
					if (node.getParent().getData().compareTo(node.getData()) > 0) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					} else {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					}
				}

			} else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}

	}

	@Override
	public T[] preOrder() {
		ArrayList<T> lista = new ArrayList<>();
		preOrderRecursive(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[0]);
	}

	private void preOrderRecursive(ArrayList<T> lista, BSTNode<T> node) {
		if (!node.isEmpty()) {
			lista.add(node.getData());
			preOrderRecursive(lista, (BSTNode<T>) node.getLeft());
			preOrderRecursive(lista, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> lista = new ArrayList<>();
		orderRecursive(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[0]);
	}

	private void orderRecursive(ArrayList<T> lista, BSTNode<T> node) {
		if (!node.isEmpty()) {
			orderRecursive(lista, (BSTNode<T>) node.getLeft());
			lista.add(node.getData());
			orderRecursive(lista, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> lista = new ArrayList<>();
		postOrderRecursive(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[0]);
	}

	private void postOrderRecursive(ArrayList<T> lista, BSTNode<T> node) {
		if (!node.isEmpty()) {
			postOrderRecursive(lista, (BSTNode<T>) node.getLeft());	
			postOrderRecursive(lista, (BSTNode<T>) node.getRight());
			lista.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(this.getRoot());
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