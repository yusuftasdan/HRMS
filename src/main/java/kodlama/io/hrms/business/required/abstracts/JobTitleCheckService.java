package kodlama.io.hrms.business.required.abstracts;

import kodlama.io.hrms.entities.dtos.JobTitleDto;

public interface JobTitleCheckService {

	public boolean isTitleAlreadyUsed (JobTitleDto jobTitleDto);
	
	
}
