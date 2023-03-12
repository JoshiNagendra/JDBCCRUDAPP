package in.joshi.service;

import in.joshi.dto.Student;

public interface IStudentService {
	String save(Student student);
	Student findById(Integer sid);
	String updateById(Student student);
	String deleteById(Integer sid);
}
