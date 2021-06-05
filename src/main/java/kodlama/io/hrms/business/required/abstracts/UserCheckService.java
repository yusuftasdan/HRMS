package kodlama.io.hrms.business.required.abstracts;

import kodlama.io.hrms.entities.concretes.User;

public interface UserCheckService {
	
	public boolean passwordConfirmation(User user);
	
	public boolean emailVerification(User user);
	
}
