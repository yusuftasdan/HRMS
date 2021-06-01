package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobTitleService;
import kodlama.io.hrms.business.abstracts.JobTitleCheckService;
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
	public List<JobTitle> getAll() {
		
		return this.jobTitleDao.findAll();
	}



	@Override
	public void add(JobTitle jobTitle) {

		if(! jobTitleCheckService.isTitleAlreadyUsed(jobTitle)) {
			return ;
		}
		
	}
	

}
