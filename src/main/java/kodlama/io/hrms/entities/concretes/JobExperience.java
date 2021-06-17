package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	@Column(name="old_company_name")
	private String oldCompanyName;
	
	@Column(name="starting_date")
	private LocalDate startingDate;
	
	@Column(name="ending_date")
	private LocalDate endingDate;
	
	@Column(name="creating_date")
	private LocalDate creatingDate;
	
	@ManyToOne
	@JoinColumn(name="job_title_id", referencedColumnName = "id")
	private JobTitle jobTitle;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id", referencedColumnName = "id")
	private Resume resumes;

}
