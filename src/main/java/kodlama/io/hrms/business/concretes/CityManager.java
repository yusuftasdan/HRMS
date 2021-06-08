package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CityDao;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.dtos.CityDto;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CityManager(CityDao cityDao, ModelMapper modelMapper) {
		super();
		this.cityDao = cityDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<CityDto>> getAll() {
		return new SuccessDataResult<List<CityDto>>(this.cityDao.findAll().stream().map(element->modelMapper.map(element, CityDto.class)).collect(Collectors.toList()), "Data Listelendi (City)");
	}

	@Override
	public Result add(CityDto cityDto) {
		City city = modelMapper.map(cityDto,City.class);
		this.cityDao.save(city);
		return new SuccessResult("Şehir bilgisi eklendi.");
	}

}
