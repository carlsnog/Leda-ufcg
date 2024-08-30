package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {

		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<T>(),
			new DoubleLinkedListNode<T>());
			newHead.setNext(getHead());
			((DoubleLinkedListNode<T>) getHead()).setPrevious(newHead);
			if (this.isEmpty()) {
				this.setLast(newHead);
			}
			this.setHead(newHead);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.setHead(this.getHead().getNext());
			if (this.isEmpty()){
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			} else {
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!getLast().isNIL()) {
			this.setLast(this.getLast().getPrevious());
			if (getLast().isNIL()){
				this.setHead(this.getLast());
			}
			else {
				this.getLast().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}


	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
				this.setHead(newNode);
				this.setLast(newNode);
			} else {
				DoubleLinkedListNode<T> newNodeLast = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), getLast());
				this.getLast().setNext(newNodeLast);
				this.setLast(newNodeLast);
			}
		}
	}
	

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.getHead().getData().equals(element)) {
				this.removeFirst();
			}
			else if (this.getLast().getData().equals(element)) {
				this.removeLast();
			}
			else {
				DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.getHead();
				while (!auxNode.isNIL() && !auxNode.getData().equals(element)) {
					auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
				}
				if (!auxNode.isNIL()) {
					auxNode.getPrevious().setNext(auxNode.getNext());
					((DoubleLinkedListNode<T>) auxNode.getNext()).setPrevious(auxNode.getPrevious());
				}
			}
		}
	}
	

	@Override
	public T search(T element) {
		T value = null;
		if (!this.isEmpty() && element != null) {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();
			while(!auxHead.equals(auxLast) && !auxHead.getNext().equals(auxLast) &&
			!auxHead.getData().equals(element) && !auxLast.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}
			if (auxHead.getData().equals(element)) {
				value = auxHead.getData();
			}
			if (auxLast.getData().equals(element)) {
				value = auxLast.getData();
			}
		}
		return value;
	}


	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}