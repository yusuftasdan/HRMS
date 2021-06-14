package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.JobExperienceAddDto;

public interface JobExperienceService {
	
	DataResult<List<JobExperienceAddDto>> getAll();
	
	Result add(JobExperienceAddDto jobExperienceAddDto);

}
