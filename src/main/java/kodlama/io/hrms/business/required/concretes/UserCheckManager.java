package kodlama.io.hrms.business.required.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.required.abstracts.UserCheckService;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class UserCheckManager implements UserCheckService {
	
	@Override
	public boolean passwordConfirmation(User user) {
		
		return true;
	}

	@Override
	public boolean emailVerification(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
