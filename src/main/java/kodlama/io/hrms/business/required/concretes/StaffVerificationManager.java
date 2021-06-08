package kodlama.io.hrms.business.required.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.required.abstracts.StaffVerificationService;
import kodlama.io.hrms.entities.dtos.EmployerDto;

@Service
public class StaffVerificationManager implements StaffVerificationService {

	@Override
	public boolean isStaffVerificated(EmployerDto employerDto) {
		// TODO Auto-generated method stub
		return true;
	}

}
