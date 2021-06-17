package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.GraduateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.GradueteAddDto;

@RestController
@RequestMapping("/api/graduates")
public class GraduateController {
	
	private GraduateService graduateService;

	@Autowired
	public GraduateController(GraduateService graduateService) {
		super();
		this.graduateService = graduateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GradueteAddDto>> getAll(){
		return this.graduateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody GradueteAddDto gradueteAddDto) {
		return this.graduateService.add(gradueteAddDto);
	}

}
