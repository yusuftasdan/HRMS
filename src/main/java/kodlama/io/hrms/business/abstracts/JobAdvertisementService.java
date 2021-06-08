package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	
	DataResult<List<JobAdvertisementDto>> findByIsActive();

}
