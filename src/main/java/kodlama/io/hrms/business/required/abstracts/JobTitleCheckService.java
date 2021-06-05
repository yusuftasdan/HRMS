package kodlama.io.hrms.business.required.abstracts;

import kodlama.io.hrms.entities.concretes.JobTitle;

public interface JobTitleCheckService {

	public boolean isTitleAlreadyUsed (JobTitle jobTitle);
	
	
}
