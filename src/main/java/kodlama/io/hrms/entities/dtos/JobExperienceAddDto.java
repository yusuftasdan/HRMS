package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceAddDto {
	
	private int id;
	
	private String oldCompanyName;
	
	private LocalDate startingDate;
	
	private LocalDate endingDate;
	
	private LocalDate creatingDate;
	
	private int jobTitleId;
	
	private int resumesId;

}
