package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	
	public boolean isEmailAlreadyRegistered(Candidate candidate);
	
	public boolean isIdentityAlreadyRegistered(Candidate candidate);

}
