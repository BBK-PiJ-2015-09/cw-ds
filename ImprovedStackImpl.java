public class ImprovedStackImpl implements ImprovedStack {
	private StackImpl stack;

	public ImprovedStackImpl() {
		this.stack = new StackImpl(new ArrayList());
	}

	@Override
	public ImprovedStack reverse() {
		ImprovedStackImpl cache = new ImprovedStackImpl();
		ImprovedStackImpl reversed = new ImprovedStackImpl();
		int sizeCache = size();
		for(int i = sizeCache; i > 0; i--) {
			cache.push(stack.top().getReturnValue());
			reversed.push(stack.pop().getReturnValue());
		}
		for(int i = sizeCache; i > 0; i--) {
			stack.push(cache.pop().getReturnValue());
		}
		return reversed;
	}

	@Override
	public void remove(Object object) {
		ImprovedStackImpl keep = new ImprovedStackImpl();
		for(int i = stack.size(); i > 0; i--) {
			Object temp = stack.pop().getReturnValue();
			if (!temp.equals(object)) {
				keep.push(temp);
			}
		}
		for(int i = keep.size(); i > 0; i--) {
			stack.push(keep.pop().getReturnValue());
		}
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	@Override
	public int size() {
		return stack.size();
	}
	
	@Override
	public void push(Object item) {
		stack.push(item);
	}
	
	@Override
	public ReturnObject top() {
		return stack.top();
	}

	@Override
	public ReturnObject pop() {
		return stack.pop();
	}

}