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
}