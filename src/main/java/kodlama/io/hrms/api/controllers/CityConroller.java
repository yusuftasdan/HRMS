package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.CityDto;

@RestController
@RequestMapping("/api/cities")
public class CityConroller {

	private CityService cityService;
	@Autowired
	public CityConroller(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CityDto>> getAll(){
		return this.cityService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CityDto cityDto) {
		return this.cityService.add(cityDto);
	}
}
