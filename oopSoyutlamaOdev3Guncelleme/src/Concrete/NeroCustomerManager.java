package Concrete;

import Abstract.BaseCustomerManager;

public class NeroCustomerManager extends BaseCustomerManager{
	
	//Dolaylı yoldan interface'de ki save'i miras aldı. Yani interface'i de referans olarak kullanabilecek. Dolaylı yoldan miras
	//aldı diyoruz cunku BaseCustomer manager'Da ICustomerService'i implemente ediyordu.
	
	//NeroCustomerManager'da kimlik bilgisi ile doğrulama yapıldıktan sonra müşterilerini kaydetmek isterse StarbucksManager'da yaptıgımız
	//islemleri aynen yapmamız yeterli. Hatta kodumuz o kadar esnek ki istersek Nero hem default olarak sistemimizde bulunan kimlik dogrulama
	//sistemini kullanır(default olarak direkt true donen CustomerCheckManager class'ı simülasyon amacıyla tasarladık.) Hem de mernis kimlik dogrulama
	//sistemini kullanabilir. Tabi ki aynı durum StarbucksCustomerManager içinde geçerli , istersek eğer StarbucksCustomerManager'da 
	//default olarak sistemimizde bulunan kimlik dogrulama sistemini kullanabilir. Bu durum Mainde StarbucksCustomerManager newlenirken StarbucksCustomerManager'ın
	//constructorında bulunan ICustomerCheckService objesi olan customerCheckService'e ne verdiginizle ilgili.
}
