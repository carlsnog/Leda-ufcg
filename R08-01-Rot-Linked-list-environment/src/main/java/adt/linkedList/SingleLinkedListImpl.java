package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = getHead();
		while (!auxHead.isNIL()) {
			size++;
			auxHead = auxHead.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = getHead();
		if (element != null) {
			while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
				auxHead = auxHead.getNext();
			} 
		}
		return auxHead.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxHead = getHead();
			while (!auxHead.isNIL()) {
				auxHead = auxHead.getNext();				
			}
			auxHead.data = element;
			auxHead.setNext(new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (getHead().getData().equals(element)) {
				this.setHead(this.getHead().getNext());
			}
			else {
				SingleLinkedListNode<T> prev = getHead();
				SingleLinkedListNode<T> auxHead = getHead();
				while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
					prev = auxHead;
					auxHead = auxHead.getNext();
				}
				if (!auxHead.isNIL()) {
					prev.setNext(auxHead.getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxNode = getHead();
		int i = 0;
		while (!auxNode.isNIL()) {
			array[i] = auxNode.getData();
			auxNode = auxNode.getNext();
			i++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
