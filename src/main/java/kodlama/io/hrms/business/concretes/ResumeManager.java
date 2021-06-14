package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ResumeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ResumeDao;
import kodlama.io.hrms.entities.concretes.Resume;
import kodlama.io.hrms.entities.dtos.ResumeAddDto;
import kodlama.io.hrms.entities.dtos.ResumeListDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, ModelMapper modelMapper) {
		super();
		this.resumeDao = resumeDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<ResumeListDto>> getAll() {
		return new SuccessDataResult<List<ResumeListDto>>(this.resumeDao.findAll().stream().map(element->modelMapper.map(element, ResumeListDto.class)).
				collect(Collectors.toList()), "Data Listelendi (Resume).");
	}

	@Override
	public Result add(ResumeAddDto resumeAddDto) {
		Resume resume = modelMapper.map(resumeAddDto, Resume.class);
		this.resumeDao.save(resume);
		return new SuccessResult("Data Eklendi (Resume).");
		
	}
	
	
}
