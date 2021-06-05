package kodlama.io.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.StaffVerificationService;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class StaffVerificationManager implements StaffVerificationService {

	@Override
	public boolean isStaffVerificated(Employer employer) {
		// TODO Auto-generated method stub
		return true;
	}

}
