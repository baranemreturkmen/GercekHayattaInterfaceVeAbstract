package oopSoyutlamaOdev3;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entitities.Customer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//Bunlar normalde ioc containerlar ile  kontrol edilir newleme islemi bu sekilde cok fazla yapılmaz.
		//StarbucksCustomerManager'ın ve customerManager'ın içerisinde ki newlemelerden bahsediyorum
		//Ama suanda gercek bir veri tabanı ile calısmıyorum. Simülasyon yapıyorum.
		
		//Hatırlarsak eger abstract ile BaseCustomerManager'ın Main'De newlenmesini istemedigimi soylemistim
		//Sadece referans tutucu olmalı demistim. Burada da olusturdugum StarbucksCustomerManager'ın 
		//refaransını tutuyor.
		
		//Normalde sayısal islemlere tabi tutulmayan sayısal degerleri string olarak tutardık fakat 
		//kimlik dogrulama sistemi aracılıgıyla kullandıgımız fonksiyon tc parametresini Long degerde istiyor
		//bundan dolayı Long deger'de yolladık tc'mizi.
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.save(new Customer(1, "Baran Emre", "Türkmen", 1997, 27497433098L));
		
		//Senaryo geregi starbucks veri tabanına kullanıcı kaydederken kimlik dogrulaması istiyor
		//Ama nero istemiyor. Bu durumda ben bu kimlik dogrulama isini ICustomerService interface'ine
		//yazamam. Interface'e yazarsam zaten base durumunda olan abstract class'ımda bu kimlik dogrulama
		//metodunu kullanacak. Bu durumda nero'da otomaik kimlik dogrulama metodunu kullanmis olacak. 
		//Interface'e yazmayalım abstract olan base class'a yazalım zaten olmaz yukarıda sebebini acikladigim sekilde
		//abstract'da ise bu metod her turlu nero kullanır ben neronun kimlik dogrulama icin yazacagım metodu
		//kullanmasını istemiyorum.
		
		//Ozet Ayrıntılı Acıklamalar Yine Classların İcerisinde Mevcut
		//Yukarıdaki yapının kurulumu hakkında ozet gecmek gerekirse BaseCustomerManager tüm müsterilerimde var olan
		//metodları iceren ICustomerService'i implemente ediyor. NeroCustomerManager ve StarbucksCustomerManager
		//Nero ve Starbucks firmaları icin musteri kayıt islemini yapan CustomerManager classlarım. Bu classlarımda
		//BaseCustomerManager'ı extend ediyor. Dolayısıyla dolaylı yoldan da olsa ICustomerService'i implemente
		//ediyorlar. Burada  BaseCustomerManager class'ı referans tutucu gorevinde bu yuzden abstrac bir class.
		//StarbucksCustomerManager dependency injectionla bir adet ICustomerCheckService tipinde bir nesne
		//istiyor. ICustomerCheckService tipinde ki nesnelerim sayesinde ben kimlik dogrulama islemlerimi gerceklestiriyorum.
		//Dogal olarak arkada kimlik dogrulama islemlerini gerceklestirdigim classlar ICustomerCheckService'i implemente ediyorlar.
		//Base class'ında bulunan save metodunu StarbucksCustomerManager ve NeroCustomerManager extend ettiginden rahatlıkla kullanabiliyorlar
		//StarbucksCustomerManager'a kimlik dogrulaması sartına sahip oldugundan dependency injection islemi uygulandı. Dolayısıyla
		//save metodu kimlik dogrulama sistemini icerecek sekilde override edildi. Fakat kimlik dogrulama icin gereken tum kodlar
		//Solid prensibleri dogrultusunda StarbucksCustomerManager altındaki save metodu altında yapılmadı. Kimlik dogrulama icin 
		//ICustomerCheckService interface'i olusturuldu ve kimlik dogrulama islemine sahip classlar bu interface'i implemente etti
		//StarbucksCustomerManager altındaki save metodu Mainde bu interface'i implemente eden hangi class verildiyse o class'a 
		//gore kimlik dogrulama islemini yapabilecek sekilde ayarlandı. Bu ayarıda yukarıda bahsettigim sekilde dependency injection
		//ile yaptık.
		

	}

}
