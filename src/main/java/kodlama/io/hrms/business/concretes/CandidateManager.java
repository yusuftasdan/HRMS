package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateCheckService;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.UserCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	private UserCheckService userCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService,
			UserCheckService userCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
		this.userCheckService = userCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi(Candidate)");
	}

	@Override
	public Result add(Candidate candidate) {
		if (candidate.getFirstName().isBlank() || candidate.getLastName().isBlank()
				|| candidate.getIdentityNumber().isBlank() || candidate.getEmailAddress().isBlank()
				|| candidate.getPassword().isBlank()) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		} else if (!candidateCheckService.isEmailAlreadyRegistered(candidate)) {
			return new ErrorResult("Bu mail adresi kullanılmıştır.");
		} else if (!candidateCheckService.isIdentityAlreadyRegistered(candidate)) {
			return new ErrorResult("Bu Kimlik Numarası kullanılmıştır.");
		} else if (userCheckService.emailVerification(candidate)) {
			return new ErrorResult("Email onaylaması sağlanamadı.");
		} else if (!userCheckService.passwordConfirmation(candidate)) {
			return new ErrorResult("Şifre tekrarı hatalı.");
		} else {
			this.candidateDao.save(candidate);
			return new SuccessResult("İş arayan eklendi");
		}
	}

}
