package Adapters;

import java.rmi.RemoteException;


import Abstract.ICustomerCheckService;
import Entitities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements ICustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
		//Burası adapter kısmı oldugu icin mernis kimlik dogrulama sistemini dısarıdan sistemime dahil ettigim
		//adapters'ın altında newleme islemi yapabilirim.
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(customer.getNationalityId(), customer.getFirstName(), customer.getLastName(),customer.getDateOfBirth());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

}
