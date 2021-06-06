package kodlama.io.hrms.business.required.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.required.abstracts.JobTitleCheckService;
import kodlama.io.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleCheckManager implements JobTitleCheckService {

	private JobTitleDao jobTitleDao;
	
	public JobTitleCheckManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public boolean isTitleAlreadyUsed(JobTitle jobTitle) {
		if(jobTitleDao.findAllByTitle(jobTitle.getTitle()).stream().count() !=0) {
		return false;
	}
	return true;
}

}
