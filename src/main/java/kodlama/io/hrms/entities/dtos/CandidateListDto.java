package kodlama.io.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateListDto {

	private String emailAddress;
	private String firstName;
	private String lastName;
	private String identityNumber;
	private int birthyear;
	
}
