package kodlama.io.hrms.business.required.abstracts;

import kodlama.io.hrms.entities.dtos.CandidateAddDto;

public interface CandidateCheckService {
	
	public boolean isEmailAlreadyRegistered(CandidateAddDto candidateAddDto);
	
	public boolean isIdentityAlreadyRegistered(CandidateAddDto candidateAddDto);
	
	public boolean passwordConfirmation(CandidateAddDto candidateAddDto);
	
	public boolean emailVerification(CandidateAddDto candidateAddDto);

}
