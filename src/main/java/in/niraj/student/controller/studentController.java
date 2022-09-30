package in.niraj.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.niraj.student.entity.student;
import in.niraj.student.entity.subject;
import in.niraj.student.repository.studentRepository;
import in.niraj.student.repository.subjectRepository;
import in.niraj.student.request.StudentRequest;
import in.niraj.student.service.studentService;

@RestController
public class studentController {

	@Autowired
	private studentService sService;
	
	@Autowired
	private subjectRepository subRepo;
	
	@Autowired
	private studentRepository sRepo;
	@PostMapping("/student")
	public ResponseEntity<student> saveStudentDetail(@Valid @RequestBody StudentRequest studReq)
	{
		subject sub = new subject();
		sub.setRollno(studReq.getRollno());
		sub.setSub1(studReq.getSub1());
		sub.setSub2(studReq.getSub2());
		sub.setSub3(studReq.getSub3());
		
		sub = subRepo.save(sub);
		
		student stud = new student(studReq);
		stud.setSub(sub);
		
		stud = sRepo.save(stud);
		
		return new ResponseEntity<student>(stud, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/students")
	public List<student> getAllStudents()
	{
		return sService.getAllStudents();
	}
	
	@GetMapping("/student/Name")
	public List<student> getByName(@RequestParam String name)
	{
		return sService.getStudByName(name);
	}
	
	@GetMapping("/student/{rollno}")
	public List<student> getByRollno(@PathVariable Integer rollno)
	{
		return sRepo.getByRollno(rollno);
	}
	
	@PutMapping("/student/{id}")
	public student updateById(@PathVariable Long id, @RequestBody student stud)
	{
		return sService.updateById(id, stud);
	}
	
//	@GetMapping("/student/rollnoandstream")
//	public List<student> readByRollnoAndStream(@RequestParam BigInteger rollno, @RequestParam String stream)
//	{
//		return sService.readByRollnoAndStream(rollno, stream);
//	}
	
	@DeleteMapping("/student/delete/{id}")
	public void deleteById(@PathVariable Long id)
	{
		sService.deleteById(id);
	}
}
