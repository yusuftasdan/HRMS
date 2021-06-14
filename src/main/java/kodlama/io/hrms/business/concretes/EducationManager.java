package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.dtos.EducationAddDto;
import kodlama.io.hrms.entities.dtos.EducationListDto;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	private ModelMapper modelMapper;

	@Autowired
	public EducationManager(EducationDao educationDao, ModelMapper modelMapper) {
		super();
		this.educationDao = educationDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<EducationListDto>> getAll() {
		return new SuccessDataResult<List<EducationListDto>>(this.educationDao.findAll().stream().map(element->modelMapper.map(element, EducationListDto.class)).
				collect(Collectors.toList()),"Data Listelendi (Education).");
	}

	@Override
	public Result add(EducationAddDto educationAddDto) {
		Education education = modelMapper.map(educationAddDto, Education.class);
		this.educationDao.save(education);
		return new SuccessResult("Data Eklendi (Education)");
	}

}
