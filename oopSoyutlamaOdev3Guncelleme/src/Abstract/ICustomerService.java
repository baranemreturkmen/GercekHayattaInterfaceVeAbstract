package Abstract;

import Entitities.Customer;

public interface ICustomerService {
	
	//Tüm müşterilerimde var olan metodları interface ile soyutlamalısın. Bu şekilde ortak metodlarımı gruplamış oluyorum ve sisteme yeni müşteriler eklendiğinde
	//ve bu interface'i implemente ettiklerinde ortak metodları da içermek zorunda kalıcaklar. Dolayısıyla olması gereken metodları içermeyen bir müşteri class'ı
	//kalmayacak. Eklenen müşteri class'larından biri bu interface'in altındaki metodları içermek istemiyorsa eğer o müşteri için farklı dizayn yoluna gidilebilir.
	//Tabi bu farklı dizayn durumu overdizayn denilen durumu ortaya çıkarmamalı kararında olmalı.
	
	void save(Customer customer) throws Exception;

}
