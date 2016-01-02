public class ReturnObjectImpl implements ReturnObject {
	private Object object;
	private ErrorMessage errorMessage;
	
	public ReturnObjectImpl(Object object) {
		this.object = object;
		this.errorMessage = ErrorMessage.NO_ERROR;
	}
	
	public ReturnObjectImpl(ErrorMessage errorMessage) {
		this.object = null;
		this.errorMessage = errorMessage;
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
