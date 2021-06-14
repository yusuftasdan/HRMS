package kodlama.io.hrms.business.required.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.required.abstracts.JobTitleCheckService;
import kodlama.io.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms.entities.dtos.JobTitleDto;

@Service
public class JobTitleCheckManager implements JobTitleCheckService {

	private JobTitleDao jobTitleDao;
	
	public JobTitleCheckManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public boolean isTitleAlreadyUsed(JobTitleDto jobTitleDto) {
		if(jobTitleDao.findAllByTitle(jobTitleDto.getTitle()).stream().count() !=0) {
		return false;
	}
	return true;
}

}
