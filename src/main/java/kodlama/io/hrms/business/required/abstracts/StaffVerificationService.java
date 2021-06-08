package kodlama.io.hrms.business.required.abstracts;

import kodlama.io.hrms.entities.dtos.EmployerDto;

public interface StaffVerificationService {

	public boolean isStaffVerificated(EmployerDto employerDto);
	
}
