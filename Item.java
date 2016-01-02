public class Item {
	private Object object;
	private Item nextItem;
	
	/**
	 * Constructor
	 *
	 * @param the object to be saved	
	 */
	public Item(Object object) {
		this.object = object;
	}
		
	/**
	 * Add the next item in the list, or if there 
	 * is already one, pass it to the next item. 
	 * 
  	 * @param the object to be saved	
	 */
	public void add(Object object) {
		if (nextItem == null) {
			nextItem = new Item(object);
		} else {
			nextItem.add(object);
		}
	}
}