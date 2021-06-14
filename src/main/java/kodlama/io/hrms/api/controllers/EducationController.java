package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.EducationAddDto;
import kodlama.io.hrms.entities.dtos.EducationListDto;

@RestController
@RequestMapping("/api/educations")
public class EducationController {
	
	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<EducationListDto>> getAll(){
		return this.educationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationAddDto educationAddDto) {
		return this.educationService.add(educationAddDto);
	}
	

}
