package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.LanguageAddDto;

@RestController
@RequestMapping("/api/languages")
public class LanguageConrtoller {
	
	private LanguageService languageService;

	@Autowired
	public LanguageConrtoller(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<LanguageAddDto>> getAll(){
		return this.languageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LanguageAddDto languageAddDto) {
		return this.languageService.add(languageAddDto);
	}

}
