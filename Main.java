package gett;

public class Main {

	public static void main(String[] args) {

		Test test = new Test(1000);
		System.out.println("4: " + test.get(4));
	 	test.set(4, "test");
		System.out.println("4: " + test.get(4));
		
		test.set(6, 3454);
		System.out.println("6: " + test.get(6));
		
		
		test.setAll("0");
		test.setAll("0");
		test.setAll("0");
		test.setAll("0");
		test.setAll("0");
		
		System.out.println("4: " + test.get(4));
		System.out.println("6: " + test.get(6));
		System.out.println("5: " + test.get(5));
		
		test.set(6, 3454);
		System.out.println("6: " + test.get(6));
		System.out.println("4: " + test.get(4));
	    System.out.println("5: " + test.get(5));
	    
	    test.setAll("999");
	    System.out.println("6: " + test.get(6));
		System.out.println("4: " + test.get(4));
	    System.out.println("5: " + test.get(5));
		
	}
}

class Test {

	private int setAll_Counter = 0;
	private int setByUser_Counter = 0;
	private DataItem[] data;
	private Object defaultValue = null;
	private int DataLength;

	public Test(int N) {
		DataLength =N;
		data = new DataItem[DataLength];
	}

	public void setAll(Object value) {
		defaultValue = value;
		setAll_Counter = setByUser_Counter;
		setAll_Counter++;
	}

	public void set(int index, Object value) {
		setByUser_Counter = setAll_Counter;
		setByUser_Counter++;
		data[index] = new DataItem(setByUser_Counter, value);
	}

	public Object get(int index) throws ArrayIndexOutOfBoundsException {

		if (index>=DataLength) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		DataItem tmpObjcet = data[index];
		if ((tmpObjcet == null) || (tmpObjcet.getCounter() <= setAll_Counter)) {
			return defaultValue;
		} else {
			return tmpObjcet.getValue();
		}
	}

	private class DataItem {

		private int counter;
		private Object value;

		public DataItem(int current, Object value) {
			setCounter(current);
			setValue(value);
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public int getCounter() {
			return counter;
		}

		public void setCounter(int counter) {
			this.counter = counter;
		}

	}

}
