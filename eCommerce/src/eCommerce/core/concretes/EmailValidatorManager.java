package eCommerce.core.concretes;

import eCommerce.core.abstracts.ValidatorService;

public class EmailValidatorManager implements ValidatorService{

	@Override
	public void sendVarificationMail() {
		System.out.println("Do�rulama maili yolland�");
		System.out.println("L�tfen sisteme kay�t oldu�unuz mail adresini kontrol ediniz.");
		
	}

}
