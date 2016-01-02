public class ReturnObjectImplTest {

	public static void main(String[] args) {
		ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		System.out.println(returnObj.hasError() == false);
		System.out.println(returnObj.getError() == ErrorMessage.NO_ERROR);
		System.out.println(returnObj.getReturnValue() == null);
	}

}