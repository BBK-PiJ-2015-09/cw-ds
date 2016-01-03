public class FunctionalArrayList extends ArrayList implements FunctionalList {

	@Override
	public ReturnObject head() {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			return new ReturnObjectImpl(getList()[0]);
		}
	}
	
	@Override
	public FunctionalArrayList rest() {
		if (isEmpty()) {
			return new FunctionalArrayList();		
		} else {
			FunctionalArrayList rest = new FunctionalArrayList();
			for(int i = 1; i < size(); i++) {
				rest.add(getList()[i]);
			}
			return rest;
		}
	}
}