package kodlama.io.hrms.business.required.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.required.abstracts.CandidateCheckService;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.dtos.CandidateAddDto;

 @Service
public class CandidateCheckManager implements CandidateCheckService {

	private CandidateDao candidateDao;
		
		@Autowired
		public CandidateCheckManager(CandidateDao candidateDao) {
			super();
			this.candidateDao = candidateDao;
		}

		@Override
		public boolean isEmailAlreadyRegistered(CandidateAddDto candidateAddDto) {
			if (candidateDao.findAllByEmailAddress(candidateAddDto.getEmailAddress()).stream().count() !=0) {
				return false;
			}
			return true;
			
		}

		@Override
		public boolean isIdentityAlreadyRegistered(CandidateAddDto candidateAddDto) {
			if (candidateDao.findAllByIdentityNumber(candidateAddDto.getIdentityNumber()).stream().count() !=0) {
				return false;
			}
			return true;
		}

		@Override
		public boolean passwordConfirmation(CandidateAddDto candidateAddDto) {
			return false;
		}

		@Override
		public boolean emailVerification(CandidateAddDto candidateAddDto) {
			// TODO Auto-generated method stub
			return false;
		}

}
