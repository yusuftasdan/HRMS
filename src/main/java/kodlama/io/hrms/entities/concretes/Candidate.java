package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@OneToMany(mappedBy = "candidate")
	private List<Resume> resumes;
}
