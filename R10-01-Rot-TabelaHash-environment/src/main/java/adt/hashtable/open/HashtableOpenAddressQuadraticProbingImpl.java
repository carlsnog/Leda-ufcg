package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && this.search(element) == null) {
            if (super.isFull()) 
				throw new HashtableOverflowException();

            int prob = 0;
            boolean incluido = false;
            int hash;

            while (!incluido) {
                hash = this.getHash(element, prob++);

                if (super.table[hash] == null
                        || super.table[hash].equals(super.deletedElement)) {
                    super.table[hash] = element;
                    incluido = true;
                    super.elements++;
                } else {
                    super.COLLISIONS++;
                }
            }
        }
	}

	@Override
	public void remove(T element) {
		if (element != null && !(super.isEmpty())) {
            int hash;
            boolean found = false;
            int i = 0;

            while (!found && i < super.table.length) {
                hash = this.getHash(element, i);

                if (super.table[hash] == null) {
                    found = true;
                } else if (super.table[hash].equals(element)) {
                    super.table[hash] = super.deletedElement;
                    found = true;
                    super.elements--;
                    super.COLLISIONS -= i;
                }
                i++;
            }
        }	
	}

	@Override
	public T search(T element) {
        T value = null;
        if (element != null && !(super.isEmpty())) {
            int hash = this.indexOf(element);
            if (hash != -1) {
                value = (T) super.table[hash];
            }
        }
        return value;	
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		if (element != null && !(super.isEmpty())) {
            int hash;
            boolean found = false;
            int i = 0;
			
            while (!found && i < super.table.length) {
                hash = this.getHash(element, i++);

                if (super.table[hash] == null
                        || super.table[hash].equals(super.deletedElement)) {
                    found = true;
                } else if (super.table[hash].equals(element)) {
                    index = hash;
                    found = true;
                }
            }
        }
        return index;	
	}

	private int getHash(T element, int probe) {
        return Math.abs(((HashFunctionOpenAddress<T>) super.hashFunction).hash(element, probe));
    }
}
