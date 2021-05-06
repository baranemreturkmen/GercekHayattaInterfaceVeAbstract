package Abstract;

import Entitities.Customer;

public interface ICustomerCheckService {
	
	//Bu interface altında kimlik dogrulaması icin gerekli metodlar gruplanacak kimlik dogrulaması yapan classlar bu interface'i 
	//implemente edecekler.
	
	boolean checkIfRealPerson(Customer customer);

}
