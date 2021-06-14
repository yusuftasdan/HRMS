package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.EducationAddDto;
import kodlama.io.hrms.entities.dtos.EducationListDto;

public interface EducationService {
	
	DataResult<List<EducationListDto>> getAll();
	
	Result add(EducationAddDto educationAddDto);

}
