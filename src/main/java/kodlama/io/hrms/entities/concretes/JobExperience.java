package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="starting_date")
	private LocalDate startingDate;
	
	@Column(name="ending_date")
	private LocalDate endingDate;
	
	@Column(name="creating_date")
	private LocalDate creatingDate;
	
	@ManyToOne
	@JoinColumn(name="job_title_id", referencedColumnName = "id")
	private JobTitle jobTitle;
	
	@OneToMany(mappedBy = "jobExperience")
	private List<Resume> resume;

}
