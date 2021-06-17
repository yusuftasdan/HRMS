package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeListDto {

	private String photo;

	private String githubLink;

	private String linkedinLink;

	private String description;

	private LocalDate creatingDate;

	private LocalDate updatingDate;

	private boolean isActive;

	private List<Technology> technologies;

	private List<Language> languages;

	private List<JobExperience> jobExperience;
	
	private List<Education> education;

	private int candidateId;
	
	private String candidateFirstName;
	
}
