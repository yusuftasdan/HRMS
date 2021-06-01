package kodlama.io.hrms.core.adapters;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface UserVerificationService {

	boolean validate(Candidate candidate);
	
}
