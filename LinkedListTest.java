public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println(list.isEmpty() == true);
		list.add("first object");
		System.out.println(list.isEmpty() == false);
	}
}