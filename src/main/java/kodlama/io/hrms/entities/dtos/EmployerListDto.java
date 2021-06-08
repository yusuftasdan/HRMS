package kodlama.io.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerListDto {
	
	private String emailAddress;
	private String companyName;
	private String webAddress;
	private String phoneNumber;

}
