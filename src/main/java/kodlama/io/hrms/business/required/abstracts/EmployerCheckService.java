package kodlama.io.hrms.business.required.abstracts;

import kodlama.io.hrms.entities.dtos.EmployerDto;

public interface EmployerCheckService {

	public boolean checkEmailAndDomain(EmployerDto employerDto);

	public boolean isEmailAlreadyRegistered(EmployerDto employerDto);

	public boolean passwordConfirmation(EmployerDto EmployerDto);

	public boolean emailVerification(EmployerDto employerDto);

}
