package kodlama.io.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {

	private String emailAddress;
	private String password;
	private String companyName;
	private String webAddress;
	private String phoneNumber;

}
