package in.niraj.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.niraj.student.entity.student;

public interface studentRepository extends JpaRepository<student, Long> {

	public List<student> findByName(String name);
	
	//List<student> findByRollnoAndStream(BigInteger rollno, String stream);
	
	public List<student> findByStream(String stream);
	
	@Query("FROM student WHERE sub.rollno = :rollno")
	public List<student> getByRollno(Integer rollno);
	
	
}
