package kodlama.io.hrms.business.required.abstracts;

import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerCheckService {
	
	public boolean checkEmailAndDomain(Employer employer);
	
	public boolean isEmailAlreadyRegistered(Employer employer);

}