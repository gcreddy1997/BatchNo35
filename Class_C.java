package Java_Programs;

public class Class_C extends Class_P {
	// if there is no name conflict in methods.
	// if methods names different then which method is called that class method will execute..
	
	public void method() {
		System.out.println("Class C is executing");
	}

	//method name conflict:
	// object created for class hence, class c method will preffered..
	// method names are equal but parameters different
	// which parameter is mapping that method will be execute
	// in this case the parameters which are mapping...
	
	public static void main(String[] args) {
		Class_C obj = new Class_C();
		obj.method(12);		
	}

}
