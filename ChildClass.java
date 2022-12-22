package Java_Programs;

public class ChildClass extends ParentClass  {
	String name = "Abigna";
	int rno = 102;
	
	public  void studentDetails2() {
		System.out.println("Miss "+ super.name +" rno is "+super.rno);		
	}
	//Variable name conflict
	// when there is name conflict in between child class and the parent variables
	// by default the object to whom it was create that variable will be considered..
	
	// if there is a name conflict in between child class and parent class variables
	// if object is created for child class then child class variables will be preffered...
   // if you want represent the parent class variable then we can use super.variablename.
	
	// if object created in between the parent class and parent class then child methods and variables are not reflecting..
	
	// dynamic dispatch Method
	   // if object created in between parent class and child class will be called dynamic dispatch method..
	// 
	public static void main(String[] args) {
		// object created for childclass
		// obj can access parent and child class variables and methods...
		ChildClass obj = new ChildClass();  // dynamic dispatch method...
		obj.name="Rahul";
		obj.studentDetails2();
		

	}

}
