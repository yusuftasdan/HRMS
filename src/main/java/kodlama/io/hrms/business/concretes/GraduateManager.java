package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.GraduateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.GraduateDao;
import kodlama.io.hrms.entities.concretes.Graduate;
import kodlama.io.hrms.entities.dtos.GradueteAddDto;

@Service
public class GraduateManager implements GraduateService {

	private GraduateDao graduateDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public GraduateManager(GraduateDao graduateDao, ModelMapper modelMapper) {
		super();
		this.graduateDao = graduateDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<GradueteAddDto>> getAll() {
		return new SuccessDataResult<List<GradueteAddDto>>(this.graduateDao.findAll().stream().map(element->modelMapper.map(element, GradueteAddDto.class)).
				collect(Collectors.toList()),"Data Listelendi (Graduate).");
	}

	@Override
	public Result add(GradueteAddDto gradueteAddDto) {
		Graduate graduate = modelMapper.map(gradueteAddDto, Graduate.class);
		this.graduateDao.save(graduate);
		return new SuccessResult("Data Eklendi(Graduate).");
	}

}
