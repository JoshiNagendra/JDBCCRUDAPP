package in.joshi.controller;

import in.joshi.dto.Student;
import in.joshi.factory.StudentServiceFactory;
import in.joshi.service.IStudentService;

public class StudentControllerImpl implements IStudentController {
    IStudentService studentService;
	@Override
	public String save(Student student) {
		IStudentService studentService;
		
		studentService=StudentServiceFactory.getStudentService();
		System.out.println("The Implementation class name :: "+studentService.getClass().getName());
		
		return studentService.save(student);
	
}

	@Override
	public Student findById(Integer sid) {
		studentService=StudentServiceFactory.getStudentService();
		return studentService.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		studentService=StudentServiceFactory.getStudentService();
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		studentService=StudentServiceFactory.getStudentService();
             
		return studentService.deleteById(sid);
	}
		
}
