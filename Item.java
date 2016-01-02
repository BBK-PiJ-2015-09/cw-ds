public class Item {
	private Object object;
	private Item nextItem;
	private int index;
	
	/**
	 * Constructor
	 *
	 * @param the object to be saved
	 * @param this item's index in the list
	 */
	public Item(Object object, int index) {
		this.object = object;
		this.index = index;
	}

	/**
	 * object getter
	 *
	 * @return object
	 */
	public Object getObject() {
		return object;
	}
	
	/**
	 * nextItem getter
	 *
	 * @return nextItem
	 */
	public Item getNext() {
		return nextItem;
	}
	
	/**
	 * index getter
	 *
	 * @return index
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * If the index matches this item's index, return
	 * the object; otherwise call get on the nextItem.
	 *
  	 * @param the index of the object to be returned	
	 * @return the object to be returned
	 */
	public Object get(int index) {
		if (this.index == index) {
			return object;
		} else {
			return nextItem.get(index);
		}
	}

	/**
	 * If the index matches the index of the nextItem,
	 * remove the next item from the list, decrement the
	 * indices of all following items and return the
	 * removed object.
	 * Otherwise call remove on the nextItem.
	 *
	 * @param the index to be removed
	 * @return the object of the removed Item
	 */
	public Object remove(int index) {
		if (nextItem.getIndex() == index) {
			Object removedObject = nextItem.getObject();
			nextItem = nextItem.getNext();
			nextItem.decrementIndex();
			return removedObject;
		} else {
			return nextItem.remove(index);
		}
	}

	/**
	 * Add the next item in the list, or if there 
	 * is already one, pass it to the next item. 
	 * 
  	 * @param the object to be saved	
	 */
	public void add(Object object) {
		if (nextItem == null) {
			nextItem = new Item(object, index + 1);
		} else {
			nextItem.add(object);
		}
	}
	
	/**
	 * Decrease index by 1. Call decrementIndex on the nextItem.
	 */
	public void decrementIndex() {
		index--;
		if (nextItem != null) {
			nextItem.decrementIndex();
		}
	}
}