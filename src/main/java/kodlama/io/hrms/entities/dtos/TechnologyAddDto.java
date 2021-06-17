package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyAddDto {
	
	private int id;
	
	private String description;

	private LocalDate creatingDate;
	
	private int resumesId;

}
