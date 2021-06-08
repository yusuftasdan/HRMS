package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.required.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.required.abstracts.StaffVerificationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.dtos.EmployerDto;
import kodlama.io.hrms.entities.dtos.EmployerListDto;
@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	private StaffVerificationService staffVerificationService;
	private ModelMapper modelMapper;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService, ModelMapper modelMapper,
			StaffVerificationService staffVerificationService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
		this.modelMapper = modelMapper;
		this.staffVerificationService = staffVerificationService;
	}

	@Override
	public DataResult<List<EmployerListDto>> getAll() {
		return new SuccessDataResult<List<EmployerListDto>>(this.employerDao.findAll().stream().map(element->modelMapper.map(element, EmployerListDto.class)).collect(Collectors.toList()), "Data Listelendi(Employer).");
	}

	@Override
	public Result add(EmployerDto employerDto) {
		if (employerDto.getCompanyName().isBlank() || employerDto.getEmailAddress().isBlank()
				|| employerDto.getPassword().isBlank() || employerDto.getPhoneNumber().isBlank()) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		} else if (!employerCheckService.isEmailAlreadyRegistered(employerDto)) {
			return new ErrorResult("Bu mail adresi kullanılmıştır.");
		} else if (!employerCheckService.checkEmailAndDomain(employerDto)) {
			return new ErrorResult("mail adresi ile domain aynı olmalı.");
		} else if (!staffVerificationService.isStaffVerificated(employerDto)) {
			return new ErrorResult("Sistem onayı verilmedi.");
		}else if(employerCheckService.emailVerification(employerDto)) {
			return new ErrorResult("Email onaylaması sağlanamadı.");
		}else if(!employerCheckService.passwordConfirmation(employerDto)) {
			return new ErrorResult("Şifre tekrarı hatalı.");
		}else {
			Employer employer=modelMapper.map(employerDto, Employer.class);
			this.employerDao.save(employer);
			return new SuccessResult("İşveren eklendi.");
		}

	}

}
