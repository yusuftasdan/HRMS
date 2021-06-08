package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.required.abstracts.CandidateCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.dtos.CandidateAddDto;
import kodlama.io.hrms.entities.dtos.CandidateListDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	private ModelMapper modelMapper;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService, ModelMapper modelMapper) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<CandidateListDto>> getAll() {
		return new SuccessDataResult<List<CandidateListDto>>(this.candidateDao.findAll().stream().map(element->modelMapper.map(element,CandidateListDto.class)).collect(Collectors.toList()), "Data Listelendi(Candidate)");
	}

	@Override
	public Result add(CandidateAddDto candidateAddDto) {
		if (candidateAddDto.getFirstName().isBlank() || candidateAddDto.getLastName().isBlank()
				|| candidateAddDto.getIdentityNumber().isBlank() || candidateAddDto.getEmailAddress().isBlank()
				|| candidateAddDto.getPassword().isBlank()) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		} else if (!candidateCheckService.isEmailAlreadyRegistered(candidateAddDto)) {
			return new ErrorResult("Bu mail adresi kullanılmıştır.");
		} else if (!candidateCheckService.isIdentityAlreadyRegistered(candidateAddDto)) {
			return new ErrorResult("Bu Kimlik Numarası kullanılmıştır.");
		} else if (candidateCheckService.emailVerification(candidateAddDto)) {
			return new ErrorResult("Email onaylaması sağlanamadı.");
		} else if (candidateCheckService.passwordConfirmation(candidateAddDto)) {
			return new ErrorResult("Şifre tekrarı hatalı.");
		} else {
			Candidate candidate = modelMapper.map(candidateAddDto, Candidate.class);
			this.candidateDao.save(candidate);
			return new SuccessResult("İş arayan eklendi");
		}
	}

}
