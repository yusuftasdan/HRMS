package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceAddDto {
	
	private String companyName;
	
	private LocalDate startingDate;
	
	private LocalDate endingDate;
	
	private LocalDate creatingDate;
	
	private String jobTitleId;

}
