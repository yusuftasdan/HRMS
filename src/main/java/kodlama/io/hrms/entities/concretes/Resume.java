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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resumes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="description")
	private String description;
	
	@Column(name="creating_date")
	private LocalDate creatingDate;
	
	@Column(name="updating_date")
	private LocalDate updatingDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name= "technology_id",referencedColumnName = "id" )
	private Technology technology;
	
	@ManyToOne
	@JoinColumn(name="language_id", referencedColumnName = "id")
	private Language language;
	
	@ManyToOne
	@JoinColumn(name="jobExperience_id", referencedColumnName = "id")
	private JobExperience jobExperience;
	
	@ManyToOne
	@JoinColumn(name="education_id", referencedColumnName = "id")
	private Education education;
	
	@ManyToOne
	@JoinColumn(name="candidate_id",referencedColumnName = "id")
	private Candidate candidate;

}
