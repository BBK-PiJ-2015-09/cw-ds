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
		LinkedList stackList = new LinkedList();
		StackImpl stack = new StackImpl(stackList);
		runStackTests(stack);
		ImprovedStackImpl improvedStack = new ImprovedStackImpl();
		runStackTests(improvedStack);
		runImprovedStackTests(improvedStack);
	}
	
	private static void runImprovedStackTests(ImprovedStack stack) {
		System.out.println(stack.isEmpty() == true);
		System.out.println(stack.size() == 0);
		stack.push("first object");
		stack.push("second object");
		stack.push("third object");
		ImprovedStack reversed = stack.reverse();		
		System.out.println(reversed.pop().getReturnValue() == "first object");
		System.out.println(reversed.pop().getReturnValue() == "second object");
		System.out.println(reversed.pop().getReturnValue() == "third object");
		System.out.println(reversed.pop().getError() == ErrorMessage.EMPTY_STRUCTURE);
	}
	
	private static void runStackTests(Stack stack) {
		System.out.println(stack.isEmpty() == true);
		System.out.println(stack.size() == 0);
		stack.push("first object");
		System.out.println(stack.isEmpty() == false);
		System.out.println(stack.size() == 1);
		System.out.println(stack.top().getReturnValue() == "first object");
		stack.push("second object");
		System.out.println(stack.top().getReturnValue() == "second object");
		System.out.println(stack.isEmpty() == false);
		System.out.println(stack.size() == 2);
		System.out.println(stack.pop().getReturnValue() == "second object");
		System.out.println(stack.isEmpty() == false);
		System.out.println(stack.size() == 1);
		System.out.println(stack.pop().getReturnValue() == "first object");
		System.out.println(stack.isEmpty() == true);
		System.out.println(stack.size() == 0);
		System.out.println(stack.pop().getError() == ErrorMessage.EMPTY_STRUCTURE);
	}
	
	private static void runTests(List list) {
		System.out.println(list.isEmpty() == true);
		System.out.println(list.size() == 0);
		System.out.println(list.get(0).getError() == ErrorMessage.EMPTY_STRUCTURE);
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
		System.out.println(list.get(0).getError() == ErrorMessage.EMPTY_STRUCTURE);
		list.add("first object");
		list.add("third object");
		list.add(1, "second object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 3);
		System.out.println(list.get(0).getReturnValue() == "first object");
		System.out.println(list.get(1).getReturnValue() == "second object");
		System.out.println(list.get(2).getReturnValue() == "third object");
		System.out.println(list.remove(2).getReturnValue() == "third object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 2);
		System.out.println(list.remove(1).getReturnValue() == "second object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 1);
		System.out.println(list.remove(0).getReturnValue() == "first object");
		System.out.println(list.isEmpty() == true);
		System.out.println(list.size() == 0);
		System.out.println(list.remove(0).getError() == ErrorMessage.EMPTY_STRUCTURE);
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