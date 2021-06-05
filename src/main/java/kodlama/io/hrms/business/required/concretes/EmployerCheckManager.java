package kodlama.io.hrms.business.required.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.required.abstracts.EmployerCheckService;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService {

	private EmployerDao employerDao;

	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public boolean checkEmailAndDomain(Employer employer) {
		String[] employerWebsite = employer.getWebAddress().split("www.",2);
		String website = employerWebsite[1];
		
		String[] employerEmail = employer.getEmailAddress().split("@");
		String employerDomain = employerEmail[1];
		
		if (employerDomain.equals(website)) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean isEmailAlreadyRegistered(Employer employer) {
		if (employerDao.findAllByEmailAddress(employer.getEmailAddress()).stream().count()!=0) {
			return false;
		}
		return true;
	}

}
