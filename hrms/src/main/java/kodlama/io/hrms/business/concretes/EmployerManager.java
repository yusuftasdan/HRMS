package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.StaffVerificationService;
import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.UserCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	private StaffVerificationService staffVerificationService;
	private UserCheckService userCheckService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService,
			StaffVerificationService staffVerificationService, UserCheckService userCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
		this.staffVerificationService = staffVerificationService;
		this.userCheckService = userCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi(Employer).");
	}

	@Override
	public Result add(Employer employer) {
		if (employer.getCompanyName().isBlank() || employer.getEmailAddress().isBlank()
				|| employer.getPassword().isBlank()) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		} else if (!employerCheckService.isEmailAlreadyRegistered(employer)) {
			return new ErrorResult("Bu mail adresi kullanılmıştır.");
		} else if (!employerCheckService.checkEmailAndDomain(employer)) {
			return new ErrorResult("mail adresi ile domain aynı olmalı.");
		} else if (!staffVerificationService.isStaffVerificated(employer)) {
			return new ErrorResult("Sistem onayı verilmedi.");
		}else if(userCheckService.emailVerification(employer)) {
			return new ErrorResult("Email onaylaması sağlanamadı.");
		}else if(!userCheckService.passwordConfirmation(employer)) {
			return new ErrorResult("Şifre tekrarı hatalı.");
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("İşveren eklendi.");
		}

	}

}
