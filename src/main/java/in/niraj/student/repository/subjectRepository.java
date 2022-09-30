package in.niraj.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.niraj.student.entity.subject;

public interface subjectRepository extends JpaRepository<subject, Integer> {

}
