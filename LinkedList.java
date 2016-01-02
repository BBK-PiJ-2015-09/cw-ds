public class LinkedList implements List {
	private Item firstItem;
	private int size;

	@Override
	public boolean isEmpty() {
		return firstItem == null;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public ReturnObject get(int index) {
		if (index >= size || index < 0) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			return new ReturnObjectImpl(firstItem.get(index));
		}
	}

	@Override
	public ReturnObject remove(int index) {
		if (index >= size || index < 0) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (firstItem.getIndex() == index) {
			Object removedObject = firstItem.getObject();
			firstItem = firstItem.getNext();
			decrementIndices();
			size--;
			return new ReturnObjectImpl(removedObject);
		} else {
			size--;
			return new ReturnObjectImpl(firstItem.remove(index));
		}
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if (index >= size || index < 0) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else if (firstItem.getIndex() == index) {
			Item oldFirstItem = firstItem;
			firstItem = new Item(item, 0);
			firstItem.setNext(oldFirstItem);
			oldFirstItem.incrementIndex();
			size++;
			return new ReturnObjectImpl();
		} else {
			firstItem.add(index, item);
			size++;
			return new ReturnObjectImpl();
		}
	}

	@Override
	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (firstItem == null) {
				firstItem = new Item(item, 0);
				size = 1;
				return new ReturnObjectImpl();
			} else {
				firstItem.add(item);
				size++;
				return new ReturnObjectImpl();
			}
		}
	}

	/**
	 * Decrease indices of all Items by 1
	 */
	private void decrementIndices() {
		if (firstItem != null) {
			firstItem.decrementIndex();
		}
	}

}