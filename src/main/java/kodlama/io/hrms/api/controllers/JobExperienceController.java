package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.JobExperienceAddDto;


@RestController
@RequestMapping("/api/experiences")
public class JobExperienceController {

	private JobExperienceService jobExpService;

	@Autowired
	public JobExperienceController(JobExperienceService jobExpService) {
		super();
		this.jobExpService = jobExpService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperienceAddDto>> getAll(){
		return this.jobExpService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperienceAddDto jobExperienceAddDto) {
		return this.jobExpService.add(jobExperienceAddDto);
	}
}
