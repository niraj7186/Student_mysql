package in.niraj.student.service;

import java.util.List;

import in.niraj.student.entity.student;

public interface studentService {
	public student saveStudentDetail(student stud);
	
	public List<student> getAllStudents();
	
	public List<student> getStudByName(String name);
	
	//public List<student> readByRollnoAndStream(BigInteger rollno, String stream);
	
	public student updateById(Long id, student stud);
	
	public student getStudById(Long id);
	
	public List<student> getByStream(String stream);
	
	public void deleteById(Long id);
}
