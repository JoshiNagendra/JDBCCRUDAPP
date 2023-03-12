package in.joshi.factory;

import in.joshi.controller.IStudentController;
import in.joshi.controller.StudentControllerImpl;

public class StudentControllerFactory {
	private static IStudentController studentController ;
	
	private StudentControllerFactory() {
		
	}
	public static IStudentController getStudentController() {
		if(studentController ==null) {
			studentController=new StudentControllerImpl();
		}
		return studentController;
		
	}


}
