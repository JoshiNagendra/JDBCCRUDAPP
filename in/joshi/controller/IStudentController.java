package in.joshi.controller;

import in.joshi.dto.Student;

public interface IStudentController {
	String save(Student student); //Create Operations
	Student findById(Integer sid); //Read Operations
	String updateById(Student student); //Update Operations
	String deleteById(Integer sid); //Delete Opearations

}
