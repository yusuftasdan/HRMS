package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.CandidateAddDto;
import kodlama.io.hrms.entities.dtos.CandidateListDto;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	
	private CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateListDto>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateAddDto candidateAddDto) {
		return this.candidateService.add(candidateAddDto);
	}

}
