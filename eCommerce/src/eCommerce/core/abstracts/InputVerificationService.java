package eCommerce.core.abstracts;

import eCommerce.entities.concretes.User;

public interface InputVerificationService {
	boolean isValid(User user);
}
