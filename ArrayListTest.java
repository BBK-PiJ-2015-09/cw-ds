public class ArrayListTest {
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		System.out.println(list.isEmpty() == true);
		System.out.println(list.size() == 0);
		list.add(0, "first object");
		System.out.println(list.get(0).getReturnValue() == "first object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 1);
		System.out.println(list.add(1, "second object").getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
		System.out.println(list.size() == 1);
		System.out.println(list.add("second object").getReturnValue() == null);
		System.out.println(list.get(0).getReturnValue() == "first object");
		System.out.println(list.get(1).getReturnValue() == "second object");
		list.remove(0);
		System.out.println(list.get(0).getReturnValue() == null);
		System.out.println(list.get(1).getReturnValue() == "second object");
		list.remove(1);
		System.out.println(list.get(1).getReturnValue() == null);
	}

}