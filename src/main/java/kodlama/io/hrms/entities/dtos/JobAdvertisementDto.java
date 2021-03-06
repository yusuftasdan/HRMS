package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private String employerCompanyName;
	private String jobTitleTitle;
	private LocalDate creatingDate;
	private LocalDate endingDate;
	private String openPosition;

}
