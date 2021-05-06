package Concrete;

import Abstract.ICustomerCheckService;
import Entitities.Customer;

public class CustomerCheckManager implements ICustomerCheckService{
	
	//Bu class ICustomerCheckService'i implemente ediyor. Simdi bu class sayesinde StarbucksCustomerManager'dan bagimsiz bir sekilde
	//bir dogrulama metodu olusturdum. Kimlik dogrulama sisteminden hata gelmezse eger default olarak true yolluyor metodumuz.
	
	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
		//Burada mernis'e ait kodları koyabilir ve calıstırabilirdik fakat bu durumda da bu metodun altında 
		//bir newleme islemi gerceklestirecektik. Bu islem yuzunden checkIfRealPerson metodum mernis kimlik dogrulama sistemine
		//tamamen bagımlı olacaktı ve bu bizim istemedigimiz birsey. Bundan dolayı mernis'i kendi sistemime entegre ederken 
		//adapters diye bir paket olusturuyorum ve adapters'ın altından mernis'i sistemime entegre ediyorum. Dış bir sistemi sisteme
		//dahil ederken bu yöntem kullanılır yani adapters denilen design patterns kullanılır. Burası bizim kendi servisimiz. Bize ait kodlar
		//burada olmalı . Dışarıdan sisteme entegre edeceğim servisler adapters'ın altında olmalı. Burası boş gözüküyor ama burada kendi servimizle
		//alakalı olan checkIfRealPerson metodu çalıştırılabilir. Burada kendi servisimizle ilgili kodların oldugunu dusunebiliriz.
		return true;
		
		
		
	}

}
