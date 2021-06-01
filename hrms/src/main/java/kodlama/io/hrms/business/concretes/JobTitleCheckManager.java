package kodlama.io.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobTitleCheckService;
import kodlama.io.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleCheckManager implements JobTitleCheckService {

	private JobTitleDao jobTitleDao;
	
	@Override
	public boolean isTitleAlreadyUsed(JobTitle jobTitle) {
		if(jobTitleDao.findAllByTitle(jobTitle.getTitle()).stream().count() !=0) {
		return false;
	}
	return true;
}

}
