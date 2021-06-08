package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

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
import kodlama.io.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {

		if (jobAdvertisementAddDto.getJobDescription().isEmpty()
				|| jobAdvertisementAddDto.getOpenPosition().isEmpty()) {
			return new ErrorResult("Lütfen zorunlu alanları doldurunuz.");
		} else {
			JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementAddDto,JobAdvertisement.class);
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("İlan başarıyla oluşturuldu.");
		}

	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByIsActive(true).stream().map(element->modelMapper.map(element, JobAdvertisementDto.class)).collect(Collectors.toList()),"Aktif ilanlar listelendi.");
		}

}
