public class FunctionalLinkedList extends LinkedList implements FunctionalList  {

	@Override
	public ReturnObject head() {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return get(0);
		}
	}
	
	@Override
	public FunctionalLinkedList rest() {
		if (isEmpty()) {
			return new FunctionalLinkedList();		
		} else {
			FunctionalLinkedList rest = new FunctionalLinkedList();
			for(int i = 1; i < size(); i++) {
				rest.add(get(i).getReturnValue());
			}
			return rest;
		}
	}

}