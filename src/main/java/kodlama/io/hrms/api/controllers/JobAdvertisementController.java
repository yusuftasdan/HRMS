package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisements")

public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/findByIsActive")
	public DataResult<List<JobAdvertisementDto>> findByIsActive(){
	return this.jobAdvertisementService.findByIsActive();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
	}

}
