package Abstract;

import Entitities.Customer;

public abstract class BaseCustomerManager implements ICustomerService{
		
	//ÇOK ÖNEMLİ !!!
	//Concrete paketinin altında bulunan NeroCustomerManager ve StarbuckCustomerManager direkt olarak ICustomerService'i
	//implemente edebilirdi. Fakat senaryo gereği her 2 MananagerClass'ımda aynı sekilde veri tabanına ekleme yapıyor.
	//Bu durumda ben bir tane Base bir Manager class'ı olusturdum. Bu base ManagerClass'ı ICustomerService'i implemente etti.
	//ve ICustomerService'i implemente ettiği için ICustomerService'i override etmek zorunda kaldı. Ben NeroCustomerManager ve
	//StarbucksCustomerManager classlarımında ortak metodları otomatik olarak kullanmasını istiyorsam eger bu class'ı extend etmeleri
	//gerekir bu sekilde otomatikman burada ki save metodunu kullanabilcekler. Eğer bu hareket yapılmasaydı ve NeroCustomerManager
	//StarbuckCustomerManager direkt olarak ICustomerService'i implemente etseydi her 2 class'ın içinde de ben ICustomerService'De bulunan
	//save metodunu implemente edip tekrar tekrar yazmak durumunda kalacaktım ve kod tekrarına düsecektim. Degismesi gereken bir
	//sey oldugu zaman save metodlarimda her 2 class'ımda da degistirecektim ama direk olarak buradan degistirirsem eger degismesi gereken
	//birseyi her 2 class'ımda da bu metodlar otomatik olarak degisecek yani bir nevi soyle dusunulebilir benim bu class'ım CustomerManager
	//classlarım icin bir base class gorevinde. ICustomerService CustomerManager tipinde ki classların ortak metodları tutuyor yani
	//ICustomerService sayesinde Manager classlarının ortak metodlarını gruplamış oluyorum. Bu base class'ım ICustomerService'i implemente
	//ediyor ve ICustomerService'de ki grupladıgım kullanılması gereken ortak metodları override etmis oluyor. CustomerManager tipinde ki 
	//classlarım bu base class'ı extend edip burada ki metodları  otomatik olarak kullanıyor. Boylece tum CustomerManager classlarında
	//bu class'da var olan burada ki metodlari kullanıyor. Degisiklik gereken durumlarda degisiklik buradan yapılıyor ve tum CustomerManager
	//tipindeki classlarımda degisiklik gerceklesmis oluyor. Eger bu base class olmasaydı CustomerManger tipindeki classlarım direkt olarak ICustomerService
	//implemente etseydi. Degisiklik durumunda ne kadar CustomerManager tipinde class'ım varsa tek tek hepsini degistirmek durumunda kalacaktım.
	//Şu unutulmasın interfaceler yalnızca govdesiz metodları imzaları tutarlar. Benim CustomerManager'lar icin base class'a ihtiyacım varsa
	//eger interface base class gorevi gormez. Bu durumda ayrı bir base class olusturulmalı ve bu base class interface'i implemente etmeli.
	//Base class'ımın abstract olmasının sebebi su ben base class'ım uzerinden islemler yapmak istemiyorum. Sadece CustomerManager tipinde ki classların
	//base class'ımı kullanmasını istiyorum. Bu durumda benim base class'ım yalnızca bir referans tutucu görevi goruyor. Sadece CustomerManager tipindeki
	//classların referansını tutuyor. Bu durumda ben BaseCustomerManager'ın yani CustomerManagerlar icin olusturdugum base class'ın Mainde newlenmesini
	//onlemeliyim. Bundan dolayı bu class'ımın basına abstract ekliyorum ve bu class'ımı soyutluyorum. Bu sekilde base class'ım govdeleri olan ve kendisini
	//extend eden classlar ile govdeli metodlarını paylasan , kendisini extend eden classların referansını tutan ama aynı zamanda da bir soyut class oluyor.
	//Sonuc olarak Manager classların interface'i implemente ediyor ama interface base class ihtiyacını karşılamıyor.
	
	//ÇOK ÖNEMLİ !!!
	//Senaryo gereği NeroCustomerManager ve StarbucksCustomerManager classları veri tabanına kullanıcı kaydetme işlemlerini aynı tabloya aynı şekilde 
	//yaptığı için base bir abstract class'a ihtiyaç duyuldu. Eğer NeroCustomerManager ve StarbucksCustomerManager classları veriyi farklı şekillerde farklı
	//tablolara kaydetseydi bu class'a gerek kalmayacaktı NeroCustomerManager ve StarbucksCustomerManager classlarının ICustomerService'i direkt olarak implemente
	//etmesinde bir sakınca ortaya çıkmayacaktı. Yani her durumda her zaman abstract class kullanmalıyız classlarımız interfaceleri dolaylı yoldan abstract 
	//class üzerinden implemente etsin diye bir şart çok yanlış olur. Eğer ortak metodlar varsa metodların içeriği farklıysa interface'i dolaylı yoldan miras almaya
	//yani base bir abstract class'a ihtiyacımız yok. 
	
	//C#'ta bu base'deki metodu bu class'ı extend eden metodlarda override edebilmek icin void'in soluna virtual anahtar kelimesi geliyor diğer türlü
	//bu metodu bu class'ı extend eden metodlarda override edemeyiz ama Java'Da boyle bir parametreye ihtiyac yok override islemi icin.
	//Bu metodu StarbucksCustomerManager içerisinde override etmem lazım çünkü StarbucksCustomerManager veri tabanına müsteri kaydederken müsteri bilgilerini
	//mernis ile dogrulamak istiyor. Bu dogrulama islemini save metodunu StarbucksCustomerManager icerisinde override ederek gerceklestirecegim.
	//Neroda boyle bir ihtiyac yok. Dolayısıyla NeroCustomerManager bu class'ı oldugu gibi kullanacagı icin NeroCustomerManager buradaki save metodunu override 
	//etmeyecek.
	
	@Override
	public void save(Customer customer) throws Exception{
		
		System.out.println("Veri tabanına kaydedildi : "+customer.getFirstName());
		
	}

}
