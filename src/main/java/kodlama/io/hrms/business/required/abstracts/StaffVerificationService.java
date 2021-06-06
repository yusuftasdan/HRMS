package kodlama.io.hrms.business.required.abstracts;

import kodlama.io.hrms.entities.concretes.Employer;

public interface StaffVerificationService {

	public boolean isStaffVerificated(Employer employer);
	
}
