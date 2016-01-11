public class ArrayList implements List {
	private Object[] list;
	private int objectCount;

	/**
	 * Constructor
	 */
	public ArrayList() {
		list = new Object[1];
		objectCount = 0;
	}

	@Override
	public boolean isEmpty() {
		if (objectCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return objectCount;
	}

	@Override
	public ReturnObject get(int index) {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index >= objectCount || index < 0) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			return new ReturnObjectImpl(list[index]);
		}
	}

	@Override
	public ReturnObject remove(int index) {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index >= objectCount || index < 0) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			Object removedObject = list[index];
			decrementIndices(index + 1);
			objectCount--;
			return new ReturnObjectImpl(removedObject);
		}
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if (index >= objectCount || index < 0) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (index + 1 >= list.length) {
				expandList();
			}
			incrementIndices(index);
			list[index] = item;
			if (objectCount == 0) {
				objectCount = 1;
			} else {
				objectCount++;
			}
			return new ReturnObjectImpl();
		}
	}
	
	@Override
	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (objectCount + 1 >= list.length) {
				expandList();
			}
			list[objectCount] = item;
			objectCount++;
			return new ReturnObjectImpl();
		}
	}
	
	/**
	 * Doubles the size of the list. Uses more memory than expanding 
	 * array by 1 each time but faster when adding many objects.
	 */
	private void expandList() {
		Object[] newList = new Object[list.length * 2];
		copyArray(list, newList);
		list = newList;
	}
	
	/**
	 * Copy from one array to another.
	 * Does not check array size.
	 *
	 * @param from the Object[] to copy from
	 * @param to the Object[] to copy to
	 */
	private void copyArray(Object[] from, Object[] to) {
		for(int i = 0; i < from.length; i++) {
			to[i] = from[i];
		}
	}

	/**
	 * Decrease the index of elements of the list starting at
	 * the given index and continuing to the end. Remove the duplicate
	 * element which remains at the end.
	 *
	 * @param index the first index to decrease at
	 */
	private void decrementIndices(int index) {
		for(int i = index; i < objectCount; i++) {
			list[i - 1] = list[i];
		}
		list[size()] = null;
	}

	/**
	 * Increase the index of elements of the list starting at
	 * the given index and continuing to the end. Leaves a duplicate
	 * element at the given index.
	 *
	 * @param index the first index to increase at
	 */
	private void incrementIndices(int index) {
		for(int i = index; i < objectCount; i++) {
			list[index + 1] = list[index];
		}
	}

}