package kodlama.io.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper=modelMapper;
	}
	
	private List<JobAdvertisementDto> dtoConverter(List<JobAdvertisement> jobAdvertisement){
		List<JobAdvertisementDto> jobAdvertisementDto =new ArrayList<JobAdvertisementDto>();
		jobAdvertisement.forEach(mapper->{
			JobAdvertisementDto dto=modelMapper.map(mapper, JobAdvertisementDto.class);
			dto.setEmployerCompanyName(mapper.getEmployer().getCompanyName());
			dto.setJobTitleName(mapper.getJobTitle().getTitle());
			jobAdvertisementDto.add(dto);
		});
		return jobAdvertisementDto;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),
				"Data Listelendi (İş İlanları)");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

		if(!jobAdvertisement.getJobTitle().getTitle().isBlank() || !jobAdvertisement.getJobDescription().isBlank() || !jobAdvertisement.getCity().getCityName().isBlank() ||
				!jobAdvertisement.getOpenPosition().isBlank()) {
			return new ErrorResult("Lütfen zorunlu alanları doldurunuz.");
		} else {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("İlan başarıyla oluşturuldu.");
		}
		
		
		
	}

}
