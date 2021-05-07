package eCommerce.core.concretes;

import eCommerce.core.abstracts.ValidatorService;

public class EmailValidatorManager implements ValidatorService{

	@Override
	public void sendVarificationMail() {
		System.out.println("Doðrulama maili yollandý");
		System.out.println("Lütfen sisteme kayýt olduðunuz mail adresini kontrol ediniz.");
		
	}

}
