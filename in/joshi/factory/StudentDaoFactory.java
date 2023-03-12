package in.joshi.factory;

import in.joshi.dao.IStudentDao;
import in.joshi.dao.StudentDaoImpl;

public class StudentDaoFactory {
	
	static IStudentDao studentDao;
	
	private StudentDaoFactory() {
			
	}
	public static IStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao =new StudentDaoImpl();
		}
		return studentDao;
	}
	

}
