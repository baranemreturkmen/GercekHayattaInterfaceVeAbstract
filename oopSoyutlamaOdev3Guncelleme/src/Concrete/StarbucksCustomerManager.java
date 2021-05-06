package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Entitities.Customer;


public class StarbucksCustomerManager extends BaseCustomerManager{
		
	//Dolaylı yoldan interface'de ki save'i miras aldı. Yani interface'i de referans olarak kullanabilecek. Dolaylı yoldan miras
	//aldı diyoruz cunku BaseCustomer manager'da ICustomerService'i implemente ediyordu.
	
	//StrabucksManager'ın kimlik dogrulamaya ihtiyacı var ben bu kimlik dogurlama isini save metodunun altında yapabilirim
	//Ama gelecekte baska bir musterimde kimlik dogrulama sistemi istediginde benim burada ki save metodunun altında yazdıgım
	//kimlik dogrulama metodunu kimlik dogrulama isteyen baska musterinin CustomerManager class'ının icinde yapmam lazım. Bu durumda
	//kod tekrarına dusecegim ve kimlik dogrulama fonksiyonu degistirildiginde tum musterilerde teker teker kodlarımı degistirmek
	//zorunda kalacagim. Bu problemden kacinmak icin ICustomerCheckService adinda bir interface olusturdum.  Olusturdugum interface'i
	//bu class'imda implemente edip , interface'imde bulunan govdesiz metodu burada doldurabilirim. Bu 1. kullanım ama daha güzel 
	//yöntem var bu yöntemin adı da dependency injection. 
	//bICustomerCheckService tipinde bu class'ın altında bir ozellik olusturdum. Bu ozelligin constructorda atamasi yapildi. Yani Mainde ben 
	//StarbuckCustomerManager'ı newledigimde ICustomerCheckService objesi vermek zorundayım. save metodunun altında verdigim ICustomerCheckService
	//objesi sayesinde checkIfRealPerson'a yani kimlik dogrulama metoduna ulasip kimlik dogrulama islemini gerceklestrimis oluyorum.
	
	//ÇOK ÖNEMLİ
	//2. yontem olan dependency injection 1. yonteme gore cok daha iyi. Dependency injection'la kast edilen bagımlılık enjeksiyonu
	//yani biz StarbucksCustomerManager'ı Main'De newlerken muhakkak ICustomerCheckService tipinde bir nesneye ihtiyacımız var
	//Bu nesnelerimiz de ICustomerCheckService'i implemente eden kimlik dogrulama fonksiyonu checkIfRealPerson metodunu içerisinde
	//bulunduran kimlik dogrulama amacıyla olusturudugumuz classlar. Biz burada ICustomerCheckService objesine bagımlıyız. Ama 
	//bu bagimlilik iyi birsey cunku senaryo geregi starbucks'ın müsterilerini veri tabanına kaydederken mutlaka kimlik dogrulama
	//sisteminden dogrulama yapması gerektigini biliyoruz. Dependency injection ile beraber starbucks musterileri veri tabanina kaydedilmeden
	//once bu kimlik dogrulama islemini zorunlu kıldık. Eger 1. yontem kullanılsaydı eger StarbucksCustomerManager ICustomerCheckService'i
	//implemente etseydi ve checkIfRealPerson burada metod olarak bulunsaydı sayet ben Mainde StarbucksCustomerManager'i manager newlerken
	//benden ICustomerCheckService tipinde bir nesne istenmeyecekti. Bu durumda kimlik dogrulama islemi yapmadan starbucks müsterilerinin 
	//sisteme kaydedilmesine yol açabilirdi. Mainde StarbucksCustomerManager newleyip save metodunu calistirirsak ve checkIfRealPerson metodunu oncesinde
	//bir sart olarak save metodundan once uyarlamazsak starbucks musterileri kimlik dogrulama sistemine gecmeden kaydedilir. Dependency injection ile
	//hem senaryoda gerçekleşmesi %100 gereken bir isteri gerçekleştirmiş olduk hemde Mainde save isleminden once  musteri kimlik dogrulaması icin 
	//yazılması gereken sartı kodlamaktan kurtulduk.
	ICustomerCheckService customerCheckService;
	
	public StarbucksCustomerManager(ICustomerCheckService customerCheckService) {
			
			this.customerCheckService = customerCheckService;
		}
	
	

	@Override
	public void save(Customer customer) throws Exception {
		
		if(customerCheckService.checkIfRealPerson(customer)) {
			super.save(customer);
			//Eger kimlik dogrulama metodumuz true donerse kayıt islemi yapılacak
			//false ise de hata fırlatacağız. 
			
			//yeni birsey ogrendik demekki illa super constructor'ın
			//altında ozellikler icin kullanacaz diye birsey yok extend ettigimiz
			//class'in metodlari icinde kullanabiliyoruz super parametresini. 
		}
		else {
			throw new Exception("Not a valid person!");
			
		}
		
	}

	
}
