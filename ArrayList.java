public class ArrayList implements List {
	Object[] list;

	/**
	 * Constructor
	 */
	public ArrayList(Object object) {
		list = new Object[1];
		list[0] = object;
	}

	@Override
	public boolean isEmpty() {
		if (list.length == 0) {
			return true;
		} else {
			return false;
		}
	}

}