package Java_Programs;

public class continue_jumpStatement {

	public static void main(String[] args) {
		String [] names = {"gcreddy","lalima","Chinmai","Chandana","vijay"};
		//	System.out.println(names[3]);
			// for each loop
			for(String name : names) {
				
				if(name=="Chinmai") {					
					    continue;   // jump statement
					    		 // Continue will be skipping specified value...					   
				}
				 System.out.println(name);
				 
				 
				
			}

	}

}
