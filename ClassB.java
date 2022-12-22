package Java_Programs;

public class ClassB {
	String name = "Sameer";
	int rno = 102;
	
	public void student2() {
		System.out.println(" Mr. "+ name + " and his rno is : "+ rno);
	}

	
	public static void main(String[] args) {
		// obj is created on behalf of ClassB
		ClassB obj = new ClassB();		
		obj.name = "Rama";
		
		ClassA obj1 = new ClassA();
		// obj1 is representing ClassA  becaouse obj1 is created on behalf of classA;
		// obj is representing ClassB
		obj1.name="Rajesh";
		obj1.student1();
		obj.student2();
		// creating an object on behalf of other class can access other class variables and methods
		// adding an object on behalf of other class is called Aggregation...
		// obj1 is comes under Aggregated object...
		
		
	}

}
