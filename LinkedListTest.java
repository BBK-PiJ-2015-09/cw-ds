public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println(list.isEmpty() == true);
		System.out.println(list.size() == 0);
		System.out.println(list.get(0).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
		list.add("first object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 1);
		System.out.println(list.get(0).getReturnValue() == "first object");
		list.add("second object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 2);
		System.out.println(list.get(0).getReturnValue() == "first object");
		System.out.println(list.get(1).getReturnValue() == "second object");
		list.remove(0);
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 1);
		System.out.println(list.get(0).getReturnValue() == "second object");
		list.remove(0);
		System.out.println(list.isEmpty() == true);
		System.out.println(list.size() == 0);
		System.out.println(list.get(0).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
	}
}