package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.TechnologyService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.TechnologyDao;
import kodlama.io.hrms.entities.concretes.Technology;
import kodlama.io.hrms.entities.dtos.TechnologyAddDto;

@Service
public class TechnologyManager implements TechnologyService {
	
	private TechnologyDao technologyDao;
	private ModelMapper modelMapper;

	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, ModelMapper modelMapper) {
		super();
		this.technologyDao = technologyDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<TechnologyAddDto>> getAll() {
		return new SuccessDataResult<List<TechnologyAddDto>>(this.technologyDao.findAll().stream().map(element->modelMapper.map(element, TechnologyAddDto.class)).
				collect(Collectors.toList()), "Data Listelendi (Technology).");
	}

	@Override
	public Result add(TechnologyAddDto technologyAddDto) {
		Technology tecnology = modelMapper.map(technologyAddDto, Technology.class);
		this.technologyDao.save(tecnology);
		return new SuccessResult("Data Eklendi(Technology).");
	}

}
