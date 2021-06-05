package kodlama.io.hrms.core.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlama.io.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserVerificationService {


	@Override
	public boolean validate(Candidate candidate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean result = true;
		try {
			result=client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")),candidate.getBirthYear());
		}  catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
