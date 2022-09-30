package in.niraj.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import in.niraj.student.request.StudentRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stud_details")
public class student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String stream;
	
	@Column(unique = true)
	private String email;
	
	@JoinColumn(name="roll_id")
	@OneToOne
	private subject sub;
	
	public student(StudentRequest req)
	{
		this.name = req.getName();
		this.stream = req.getStream();
		this.email = req.getEmail();
	}
}
