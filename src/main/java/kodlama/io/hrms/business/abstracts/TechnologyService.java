package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.TechnologyAddDto;

public interface TechnologyService {
	
	DataResult<List<TechnologyAddDto>> getAll();
	
	Result add(TechnologyAddDto technologyAddDto);
}
