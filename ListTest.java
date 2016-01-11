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
		runNoErrorTests(reversed.pop(), "first object");
		runNoErrorTests(reversed.pop(),"second object");
		runNoErrorTests(reversed.pop(), "third object");
		System.out.println(reversed.pop().getError() == ErrorMessage.EMPTY_STRUCTURE);
		System.out.println(stack.size() == 3);
		stack.remove("first object");
		System.out.println(stack.size() == 2);
		runNoErrorTests(stack.top(), "third object");
		stack.remove("third object");
		System.out.println(stack.size() == 1);
		runNoErrorTests(stack.top(), "second object");
		stack.remove("second object");
		System.out.println(stack.size() == 0);
		System.out.println(stack.isEmpty() == true);
		stack.push("first object");
		stack.push("first object");
		stack.push("first object");
		stack.push("second object");
		stack.push("second object");
		stack.push("third object");
		System.out.println(stack.size() == 6);
		stack.remove("first object");
		System.out.println(stack.size() == 3);
		runNoErrorTests(stack.top(), "third object");
		stack.remove("third object");
		System.out.println(stack.size() == 2);
		runNoErrorTests(stack.top(), "second object");
		stack.remove("second object");
		System.out.println(stack.size() == 0);
		System.out.println(stack.isEmpty() == true);
		System.out.println(stack.pop().getError() == ErrorMessage.EMPTY_STRUCTURE);
		stack.push(null);
		System.out.println(stack.pop().getReturnValue() == null);
		System.out.println(stack.pop().getError() == ErrorMessage.EMPTY_STRUCTURE);
		stack.remove(null);
		stack.push("first object");
		stack.push("first object");
		stack.push("first object");
		stack.push("second object");
		stack.push("second object");
		stack.push("third object");
		System.out.println(stack.size() == 6);
		stack.remove(null);
		System.out.println(stack.size() == 6);
	}
	
	private static void runStackTests(Stack stack) {
		// should not throw exception
		Stack nullListStack = new StackImpl(null);
		System.out.println(stack.isEmpty() == true);
		System.out.println(stack.size() == 0);
		stack.push("first object");
		System.out.println(stack.isEmpty() == false);
		System.out.println(stack.size() == 1);
		runNoErrorTests(stack.top(), "first object");
		stack.push("second object");
		runNoErrorTests(stack.top(), "second object");
		System.out.println(stack.isEmpty() == false);
		System.out.println(stack.size() == 2);
		runNoErrorTests(stack.pop(), "second object");
		System.out.println(stack.isEmpty() == false);
		System.out.println(stack.size() == 1);
		runNoErrorTests(stack.pop(), "first object");
		System.out.println(stack.isEmpty() == true);
		System.out.println(stack.size() == 0);
		System.out.println(stack.pop().getError() == ErrorMessage.EMPTY_STRUCTURE);
	}
	
	private static void runTests(List list) {
		System.out.println(list.isEmpty() == true);
		System.out.println(list.size() == 0);
		System.out.println(list.get(0).getError() == ErrorMessage.EMPTY_STRUCTURE);
		System.out.println(list.get(0).getReturnValue() == null);
		list.add(null);
		System.out.println(list.get(0).getReturnValue() == null);
		System.out.println(list.get(0).getError() == ErrorMessage.EMPTY_STRUCTURE);
		list.add("first object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 1);
		runNoErrorTests(list.get(0), "first object");
		list.add("second object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 2);
		runNoErrorTests(list.get(0), "first object");
		runNoErrorTests(list.get(1), "second object");
		list.remove(0);
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 1);
		runNoErrorTests(list.get(0), "second object");
		list.remove(0);
		System.out.println(list.isEmpty() == true);
		System.out.println(list.size() == 0);
		System.out.println(list.get(0).getError() == ErrorMessage.EMPTY_STRUCTURE);
		list.add("first object");
		list.add("third object");
		list.add(1, "second object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 3);
		runNoErrorTests(list.get(0), "first object");
		runNoErrorTests(list.get(1), "second object");
		runNoErrorTests(list.get(2), "third object");
		runNoErrorTests(list.remove(2), "third object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 2);
		runNoErrorTests(list.remove(1), "second object");
		System.out.println(list.isEmpty() == false);
		System.out.println(list.size() == 1);
		runNoErrorTests(list.remove(0), "first object");
		System.out.println(list.isEmpty() == true);
		System.out.println(list.size() == 0);
		System.out.println(list.remove(0).getError() == ErrorMessage.EMPTY_STRUCTURE);
		list.add("first object");
		list.add("third object");
		runNoErrorTests(list.add(1, "second object"), null);
		list.remove(0);
		runNoErrorTests(list.get(0), "second object");
		runNoErrorTests(list.get(1), "third object");
		list.add(0, "first object");
		list.add("fourth object");
		runNoErrorTests(list.get(0), "first object");
		runNoErrorTests(list.get(1), "second object");
		runNoErrorTests(list.get(2), "third object");
		runNoErrorTests(list.get(3), "fourth object");
		System.out.println(list.get(4).getReturnValue() == null);
		System.out.println(list.get(4).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
		list.remove(2);
		runNoErrorTests(list.get(0), "first object");
		runNoErrorTests(list.get(1), "second object");
		runNoErrorTests(list.get(2), "fourth object");
		System.out.println(list.get(3).getReturnValue() == null);
		System.out.println(list.get(3).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
		System.out.println(list.get(4).getReturnValue() == null);
		System.out.println(list.get(4).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
		System.out.println(list.get(-4).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
		System.out.println(list.get(100000000).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);		
	}

	private static void runFuncTests(FunctionalList list) {
		list.add("first object");
		list.add("third object");
		list.add(1, "second object");
		runNoErrorTests(list.head(), "first object");
		runNoErrorTests(list.rest().get(0), "second object");
		runNoErrorTests(list.rest().get(1), "third object");		
	}

	private static void runSampleableTests(SampleableList list) {
		list.add("first object");
		list.add("third object");
		list.add(1, "second object");
		list.add("fourth object");
		list.add("fifth object");
		runNoErrorTests(list.sample().get(0), "first object");
		runNoErrorTests(list.sample().get(1), "third object");
		runNoErrorTests(list.sample().get(2), "fifth object");
		list.remove(0);	
		runNoErrorTests(list.sample().get(0), "second object");
		runNoErrorTests(list.sample().get(1), "fourth object");
		System.out.println(list.sample().get(2).getReturnValue() == null);
		System.out.println(list.sample().get(2).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
	}

	private static void runNoErrorTests(ReturnObject returnObject, Object returnValue) {
		if (returnObject.hasError() || returnObject.getError() != ErrorMessage.NO_ERROR || returnObject.getReturnValue() != returnValue) {
			System.out.println("runNoErrorTests FAILED!!!");
		}
	}

}