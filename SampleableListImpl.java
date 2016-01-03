public class SampleableListImpl extends ArrayList implements SampleableList {
	
	public SampleableListImpl sample() {
		if (isEmpty()) {
			return new SampleableListImpl();		
		} else {
			SampleableListImpl sample = new SampleableListImpl();
			for(int i = 0; i < size(); i++) {
				if(i % 2 == 0) {
					sample.add(get(i).getReturnValue());
				}
			}
			return sample;
		}
		
	}
	
} 