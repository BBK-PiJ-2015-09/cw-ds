public class ReturnObjectImpl implements ReturnObject {
	private Object object;
	private ErrorMessage errorMessage;
	
	public ReturnObjectImpl(Object object) {
		this.object = object;
		errorMessage = ErrorMessage.NO_ERROR;
	}
	
	public ReturnObjectImpl(ErrorMessage errorMessage) {
		object = null;
		this.errorMessage = errorMessage;
	}
	
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
