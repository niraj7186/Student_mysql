package in.niraj.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.niraj.student.entity.student;
import in.niraj.student.repository.studentRepository;

@Service
public class studentServiceImpl implements studentService {

	@Autowired
	private studentRepository sRepo;
	
	@Override
	public student saveStudentDetail(student stud) {
		return sRepo.save(stud);
	}

	@Override
	public List<student> getAllStudents() {
		return sRepo.findAll();
	}

	@Override
	public List<student> getStudByName(String name) 
	{
		return sRepo.findByName(name);
	}

//	@Override
//	public List<student> readByRollnoAndStream(BigInteger rollno, String stream) {
//		return sRepo.findByRollnoAndStream(rollno, stream);
//	}

	@Override
	public student updateById(Long id, student stud) {
		student exist = getStudById(id);
		exist.setName(stud.getName() != null ? stud.getName() : exist.getName());
		exist.setEmail(stud.getEmail() != null ? stud.getEmail() : exist.getEmail());
	//	exist.setRollno(stud.getRollno() != null ? stud.getRollno() : exist.getRollno());
		exist.setStream(stud.getStream() != null ? stud.getStream() : exist.getStream());
		return sRepo.save(exist);
	}

	@Override
	public student getStudById(Long id) {
		Optional<student> stud = sRepo.findById(id);
		if (stud.isPresent()) {
			return stud.get();
		}
		throw new RuntimeException("Student not found with id "+id);
	}

	@Override
	public List<student> getByStream(String stream) {
		return sRepo.findByStream(stream);
	}

	@Override
	public void deleteById(Long id) {
		sRepo.deleteById(id);
		
	}

	

}
