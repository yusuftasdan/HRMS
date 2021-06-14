package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.ResumeAddDto;
import kodlama.io.hrms.entities.dtos.ResumeListDto;

public interface ResumeService {
	
	DataResult<List<ResumeListDto>> getAll();
	
	Result add(ResumeAddDto resumeAddDto);

}
