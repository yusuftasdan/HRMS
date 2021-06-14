package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.dtos.JobExperienceAddDto;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, ModelMapper modelMapper) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<JobExperienceAddDto>> getAll() {
		return new SuccessDataResult<List<JobExperienceAddDto>>(this.jobExperienceDao.findAll().stream().map(element-> modelMapper.map(element,JobExperienceAddDto.class))
				.collect(Collectors.toList()),"Data Listelendi (JobExperience).");
	}

	@Override
	public Result add(JobExperienceAddDto jobExperienceAddDto) {
		JobExperience jobExperience = modelMapper.map(jobExperienceAddDto, JobExperience.class);
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Data Eklendi(Job Experience).");
	}

}
