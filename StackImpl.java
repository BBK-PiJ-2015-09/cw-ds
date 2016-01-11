public class StackImpl extends AbstractStack {
	
	/**
	 * Constructor
	 */
	public StackImpl(List list) {
  	  super(list);
	}

	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}
	
	@Override
	public int size() {
		return internalList.size();
	}
	
}