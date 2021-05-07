package eCommerce.core.concretes;

import eCommerce.core.abstracts.InputVerificationService;
import eCommerce.entities.concretes.User;
import eCommerce.jGoogleUserValid.JGoogleUserVerificationService;

public class JGoogleUserVerificationServiceAdepter implements InputVerificationService{

	@Override
	public boolean isValid(User user) {
		JGoogleUserVerificationService googleUserValid  = new JGoogleUserVerificationService();
		return googleUserValid.isValid();
	}

}
