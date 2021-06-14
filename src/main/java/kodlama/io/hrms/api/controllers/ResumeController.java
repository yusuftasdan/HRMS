package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.ResumeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.ResumeAddDto;
import kodlama.io.hrms.entities.dtos.ResumeListDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ResumeListDto>> getAll(){
		return this.resumeService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody ResumeAddDto resumeAddDto) {
		return this.resumeService.add(resumeAddDto);
	}
}
