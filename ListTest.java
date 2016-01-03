public class ListTest {
	
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		runTests(arrayList);
		LinkedList linkedList = new LinkedList();
		runTests(linkedList);
		FunctionalArrayList funcArrayList = new FunctionalArrayList();
		runTests(funcArrayList);
		funcArrayList = new FunctionalArrayList();
		runFuncTests(funcArrayList);
		FunctionalLinkedList funcLinkedList = new FunctionalLinkedList();
		runTests(funcLinkedList);
		funcLinkedList = new FunctionalLinkedList();
		runFuncTests(funcLinkedList);
		SampleableListImpl sampleableList = new SampleableListImpl();
		runSampleableTests(sampleableList);
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

	private static void runFuncTests(FunctionalList list) {
		list.add("first object");
		list.add("third object");
		list.add(1, "second object");
		System.out.println(list.head().getReturnValue() == "first object");
		System.out.println(list.rest().get(0).getReturnValue() == "second object");
		System.out.println(list.rest().get(1).getReturnValue() == "third object");		
	}

	private static void runSampleableTests(SampleableList list) {
		list.add("first object");
		list.add("third object");
		list.add(1, "second object");
		list.add("fourth object");
		list.add("fifth object");
		System.out.println(list.sample().get(0).getReturnValue() == "first object");
		System.out.println(list.sample().get(1).getReturnValue() == "third object");
		System.out.println(list.sample().get(2).getReturnValue() == "fifth object");
	}

}