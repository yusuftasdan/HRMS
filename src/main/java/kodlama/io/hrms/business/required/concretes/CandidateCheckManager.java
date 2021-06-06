package kodlama.io.hrms.business.required.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.required.abstracts.CandidateCheckService;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;

 @Service
public class CandidateCheckManager implements CandidateCheckService {

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean isEmailAlreadyRegistered(Candidate candidate) {
		if (candidateDao.findAllByEmailAddress(candidate.getEmailAddress()).stream().count() !=0) {
			return false;
		}
		return true;
		
	}

	@Override
	public boolean isIdentityAlreadyRegistered(Candidate candidate) {
		if (candidateDao.findAllByIdentityNumber(candidate.getIdentityNumber()).stream().count() !=0) {
			return false;
		}
		return true;
	}

}
