public class ListTest {
	
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		LinkedList linkedList = new LinkedList();
		runTests(arrayList);
		runTests(linkedList);
	}
	
	private static void runTests(List list) {
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
		list.add("first object");
		list.add("third object");
		list.add(1, "second object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 3);
		System.out.println(list.get(0).getReturnValue() == "first object");
		System.out.println(list.get(1).getReturnValue() == "second object");
		System.out.println(list.get(2).getReturnValue() == "third object");
	}

}