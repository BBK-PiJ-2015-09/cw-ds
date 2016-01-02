public class ArrayList implements List {
	private Object[] list;
	private int length;

	/**
	 * Constructor
	 */
	public ArrayList() {
		list = new Object[1];
		length = 0;
	}

	@Override
	public boolean isEmpty() {
		if (length == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return length;
	}

}