package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.EmployerDto;
import kodlama.io.hrms.entities.dtos.EmployerListDto;

@RestController
@RequestMapping("/api/employer")

public class EmployerController {

	private EmployerService employerService;
	
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService=employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployerListDto>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerDto employerDto) {
		return this.employerService.add(employerDto);
	}
	
}
