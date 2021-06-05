package kodlama.io.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserCheckService;
import kodlama.io.hrms.entities.concretes.User;


@Service
public class UserCheckManager implements UserCheckService {

	private String pass;
	
	@Override
	public boolean passwordConfirmation(User user) {
		if(pass==user.getPassword()) {
		}
		return true;
	}

	@Override
	public boolean emailVerification(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
