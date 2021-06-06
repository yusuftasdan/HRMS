package kodlama.io.hrms.business.concretes;

import java.util.List;

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

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobTitleDao;
	private JobTitleCheckService jobTitleCheckService;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao, JobTitleCheckService jobTitleCheckService) {
		super();
		this.jobTitleDao = jobTitleDao;
		this.jobTitleCheckService = jobTitleCheckService;
	}



	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Data Listelendi (Job Title)");
	}


	@Override
	public Result add(JobTitle jobTitle) {
		if (!jobTitleCheckService.isTitleAlreadyUsed(jobTitle)) {
			return new ErrorResult("İş başlığı zaten var.");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş başlığı eklendi");
	}

}
