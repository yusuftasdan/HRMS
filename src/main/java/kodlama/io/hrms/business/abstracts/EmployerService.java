package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.EmployerDto;
import kodlama.io.hrms.entities.dtos.EmployerListDto;

public interface EmployerService {

	DataResult<List<EmployerListDto>> getAll();

	Result add(EmployerDto employerDto);

}
