package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.setData(element);
				RecursiveDoubleLinkedListImpl<T> prox = new RecursiveDoubleLinkedListImpl<>();
				prox.setPrevious(this);
				this.setNext(prox);
				if (this.getPrevious() == null) {
					RecursiveDoubleLinkedListImpl<T> nilHead = new RecursiveDoubleLinkedListImpl<>();
					nilHead.setNext(this);
					this.setPrevious(nilHead);
				}
			}
			else {
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.insert(element);
			}
			else {
				RecursiveDoubleLinkedListImpl<T> newHead = new RecursiveDoubleLinkedListImpl<>();
				
				newHead.setData(this.getData());
				this.setData(element);
				newHead.setNext(this.getNext());
				this.setNext(newHead);
				newHead.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(newHead);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if(this.getData().equals(element)) {
				if(this.getPrevious().isEmpty()) {
					this.removeFirst();
				}
				else if (this.getNext().isEmpty()) {
					this.removeLast();
				}
				else {
					this.getPrevious().setNext(this.getNext());
					((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this.getPrevious());
				}
			}
			else {
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.getPrevious().isEmpty() && this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(null);
				this.setPrevious(null);
			}
			else {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if(this.next.isEmpty()) {
				this.setData(null);
				this.setNext(null);
				if(this.getPrevious().isEmpty()) {
					this.setPrevious(null);
				}
			}
			else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
