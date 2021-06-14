package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeAddDto {

	private String photo;

	private String githubLink;

	private String linkedinLink;

	private String description;

	private LocalDate creatingDate;

	private LocalDate updatingDate;

	private boolean isActive;

	private int technologyId;

	private int languageId;

	private int jobExperienceId;

	private int candidateId;

}
