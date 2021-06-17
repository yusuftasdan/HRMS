package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageAddDto {
	
	private int id;

	private String language;

	private char level;

	private LocalDate creatingDate;
	
	private int resumesId;

}
