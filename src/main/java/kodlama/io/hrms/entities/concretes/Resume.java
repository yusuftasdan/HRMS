package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(mappedBy = "resumes", cascade = CascadeType.ALL)
	private List<Technology> technologies;
	
	@OneToMany(mappedBy = "resumes", cascade = CascadeType.ALL)
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resumes", cascade = CascadeType.ALL)
	private List<JobExperience> jobExperience;
	
	@OneToMany(mappedBy = "resumes", cascade = CascadeType.ALL)
	private List<Education> education;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name="candidate_id",referencedColumnName = "id")
	private Candidate candidate;

}
