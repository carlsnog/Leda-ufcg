package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && this.search(element) == null) {
            if (super.isFull())  
				throw new HashtableOverflowException();

            int i = 0;
            boolean inserido = false;
            int hash;

            while (!inserido) {
                hash = this.getHash(element, i++);
                if (super.table[hash] == null
                        || super.table[hash].equals(super.deletedElement)) {
                    super.table[hash] = element;
                    inserido = true;
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
            boolean encontrado = false;
            int i = 0;

            while (!encontrado && i < super.table.length) {
                hash = this.getHash(element, i);

                if (super.table[hash] == null) {
                    encontrado = true;
                } else if (super.table[hash].equals(element)) {
                    super.table[hash] = super.deletedElement;
                    encontrado = true;
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
            boolean encontrado = false;
            int i = 0;

            while (!encontrado && i < super.table.length) {
                hash = this.getHash(element, i++);
                if (super.table[hash] == null
                        || super.table[hash].equals(super.deletedElement)) {
                    encontrado = true;
                } else if (super.table[hash].equals(element)) {
                    index = hash;
                    encontrado = true;
                }
            }
        }
        return index;
    }

	private int getHash(T element, int probe) {
        return Math.abs(((HashFunctionOpenAddress<T>) super.hashFunction).hash(element, probe));
    }
}
