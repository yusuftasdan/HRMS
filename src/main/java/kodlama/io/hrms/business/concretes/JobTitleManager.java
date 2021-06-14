package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobTitleService;
import kodlama.io.hrms.business.required.abstracts.JobTitleCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms.entities.concretes.JobTitle;
import kodlama.io.hrms.entities.dtos.JobTitleDto;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobTitleDao;
	private JobTitleCheckService jobTitleCheckService;
	private ModelMapper modelMapper;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao, JobTitleCheckService jobTitleCheckService, ModelMapper modelMapper) {
		super();
		this.jobTitleDao = jobTitleDao;
		this.jobTitleCheckService = jobTitleCheckService;
		this.modelMapper = modelMapper;
	}



	@Override
	public DataResult<List<JobTitleDto>> getAll() {
		return new SuccessDataResult<List<JobTitleDto>>(this.jobTitleDao.findAll().stream().map(element->modelMapper.map(element, JobTitleDto.class)).collect(Collectors.toList()),"Data Listelendi (Job Title)");
	}


	
	@Override
	public Result add(JobTitleDto jobTitleDto) {
		JobTitle jobTitle= modelMapper.map(jobTitleDto, JobTitle.class);
		if (!jobTitleCheckService.isTitleAlreadyUsed(jobTitleDto)) {
			return new ErrorResult("İş başlığı zaten var.");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş başlığı eklendi");
	}

}
