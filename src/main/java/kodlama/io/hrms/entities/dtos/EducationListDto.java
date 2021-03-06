package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationListDto {
	
	private int id;
	
	private String schoolName;

	private String schoolDepartment;

	private LocalDate startingDate;

	private LocalDate endingDate;

	private LocalDate creatingDate;

	private String graduateDescription;
	
	private int resumeId;

}
