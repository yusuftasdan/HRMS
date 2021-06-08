package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementAddDto {
	
	private int id;
	private LocalDate creatingDate;
	private LocalDate endingDate;
	private boolean isActive;
	private String jobDescription;
	private String minSalary;
	private String maxSalary;
	private String openPosition;
	private int employerId;
	private int jobTitleId;
	private int cityId;
	
}
