public class FunctionalArrayList extends ArrayList implements FunctionalList {

	@Override
	public ReturnObject head() {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return new ReturnObjectImpl(get(0).getReturnValue());
		}
	}
	
	@Override
	public FunctionalArrayList rest() {
		if (isEmpty()) {
			return new FunctionalArrayList();		
		} else {
			FunctionalArrayList rest = new FunctionalArrayList();
			for(int i = 1; i < size(); i++) {
				rest.add(get(i).getReturnValue());
			}
			return rest;
		}
	}
}