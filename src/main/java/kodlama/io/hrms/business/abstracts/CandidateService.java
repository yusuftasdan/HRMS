package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.CandidateAddDto;
import kodlama.io.hrms.entities.dtos.CandidateListDto;

public interface CandidateService {

	DataResult<List<CandidateListDto>> getAll();

	Result add(CandidateAddDto candidateAddDto);
}
