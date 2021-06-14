package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.LanguageDao;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.dtos.LanguageAddDto;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languegeDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public LanguageManager(LanguageDao languegeDao, ModelMapper modelMapper) {
		super();
		this.languegeDao = languegeDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<LanguageAddDto>> getAll() {
		return new SuccessDataResult<List<LanguageAddDto>>(this.languegeDao.findAll().stream().map(element->modelMapper.map(element,LanguageAddDto.class))
				.collect(Collectors.toList()),"Data Listelendi(Language).");
	}

	@Override
	public Result add(LanguageAddDto languegeAddDto) {
		Language language = modelMapper.map(languegeAddDto, Language.class);
		this.languegeDao.save(language);
		return new SuccessResult("Data eklendi(Languege).");
	}

}
