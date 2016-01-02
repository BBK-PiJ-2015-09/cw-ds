public class LinkedList implements List {
	private Item firstItem;

	@Override
	public boolean isEmpty() {
		return firstItem == null;
	}
	
	@Override
	public int size() {
		return 0;
	}

	@Override
	public ReturnObject get(int index) {
		return new ReturnObjectImpl();
	}

	@Override
	public ReturnObject remove(int index) {
		return new ReturnObjectImpl();
	}

	@Override
	public ReturnObject add(int index, Object item) {
		return new ReturnObjectImpl();
	}

	@Override
	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (firstItem == null) {
				firstItem = new Item(item);
				return new ReturnObjectImpl();
			} else {
				firstItem.add(item);
				return new ReturnObjectImpl();
			}
		}
	}

}