package in.joshi.factory;

import in.joshi.service.IStudentService;
import in.joshi.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static IStudentService studentService ;
	
	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentService() {
		if (studentService == null) {
			studentService = new StudentServiceImpl();			
		}
		return studentService;
	}


}
