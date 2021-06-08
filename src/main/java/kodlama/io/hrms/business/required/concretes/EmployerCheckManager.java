package kodlama.io.hrms.business.required.concretes;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.required.abstracts.EmployerCheckService;

import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.dtos.EmployerDto;


@Service
public class EmployerCheckManager implements EmployerCheckService {

	private EmployerDao employerDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployerCheckManager(EmployerDao employerDao, ModelMapper modelMapper) {
		super();
		this.employerDao = employerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean checkEmailAndDomain(EmployerDto employerDto) {
		String[] employerWebsite = employerDto.getEmailAddress().split("www.",2);
		String website = employerWebsite[1];
		
		String[] employerEmail = employerDto.getEmailAddress().split("@");
		String employerDomain = employerEmail[1];
		
		if (employerDomain.equals(website)) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean isEmailAlreadyRegistered(EmployerDto employerDto) {
		Employer employer=modelMapper.map(employerDto, Employer.class);
		if (employerDao.findAllByEmailAddress(employer.getEmailAddress()).stream().count()!=0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean passwordConfirmation(EmployerDto employerDto) {
		return true;
	}

	@Override
	public boolean emailVerification(EmployerDto employerDto) {
		// TODO Auto-generated method stub
		return false;
	}

}
