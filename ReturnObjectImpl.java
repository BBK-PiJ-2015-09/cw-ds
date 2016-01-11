public class ReturnObjectImpl implements ReturnObject {
	private Object object;
	private ErrorMessage errorMessage;
	
	/**
	 * Constructor with object. Sets errorMessage to NO_ERROR.
	 * 
	 * @param object the object to be saved
	 */
	public ReturnObjectImpl(Object object) {
		this.object = object;
		errorMessage = ErrorMessage.NO_ERROR;
	}
	
	/**
	 * Constructor with errorMessage. Sets object to null.
	 * 
	 * @param errorMessage the error message to be saved
	 */
	public ReturnObjectImpl(ErrorMessage errorMessage) {
		object = null;
		this.errorMessage = errorMessage;
	}
	
	/**
	 * Constructor without params.
	 * Sets object to null. Sets errorMessage to null.
	 */
	public ReturnObjectImpl() {
		object = null;
		errorMessage = null;
	}
	
	@Override
	public boolean hasError() {
		return errorMessage != ErrorMessage.NO_ERROR;
	}
	
	@Override
	public ErrorMessage getError() {
		return errorMessage;
	}

	@Override
	public Object getReturnValue() {
		return object;
	}
}
