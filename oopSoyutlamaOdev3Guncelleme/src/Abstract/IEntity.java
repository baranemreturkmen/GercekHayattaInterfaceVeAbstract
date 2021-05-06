package Abstract;

public interface IEntity {
	
	//Somut classlar herhangi bir class'ı extend veya herhangi bir interface'i implemente etmiyorsa eğer ileride karşımıza nesnel zaafiyetler
	//çıkacaktır. Şu an için bu interface kullanılmıyor gibi gözüküyor ama aslıda Customer class'ı bu interface'i implemente ediyor. İleride
	//müşteri benzeri başka veri içeren classlar eklendiğinde sisteme, musteri IEntity interface'ini implemente edecekler ve musteri classlarımızı 
	//nesnel zaafiyetden kurtaracaklar. (Şu an buna ihtiyac yok gibi gozukuyor ama ileriye donuk kodu nesnel zaafiyetlerden kurtarmak için 
	//yapılmış bir hareket.)

}
