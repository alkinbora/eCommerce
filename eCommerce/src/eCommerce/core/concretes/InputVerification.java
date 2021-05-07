package eCommerce.core.concretes;

import java.util.regex.Pattern;

import eCommerce.core.abstracts.InputVerificationService;
import eCommerce.entities.concretes.User;

public class InputVerification implements InputVerificationService{

	public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }
	
	public boolean isValidPassword(String password) {
		if(password == null || password.length() < 6) {
			return false;
		}else {
			return true;
		}

	}
	
	public boolean isValidName(String name) {
		if(name == null || name.length() < 2) {
			return false;
		}
		for (char c : name.toCharArray()) {
			if(Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean isValid(User user) {
		if(!isValidEmail(user.geteMail())) {
			System.out.println("Girdi�iniz e-mail ge�ersizdir.");
			System.out.println("L�tfen ge�erli bir e-mail adresi giriniz!");
			return false;
		}
		if(!isValidName(user.getFirstName())) {
			System.out.println("Ad�n�z� yanl�� girdiniz. L�tfen en az iki karekter ve say� i�ermeyen bir ad giriniz.");
			return false;
		}
		if(!isValidName(user.getLastName())) {
			System.out.println("Soyad�n�z� yanl�� girdiniz. L�tfen en az iki karekter ve say� i�ermeyen bir soyad giriniz.");
			return false;
		}
		if(!isValidPassword(user.getPassword())) {
			System.out.println("Ge�ersiz parola. L�tfen en az 6 karakter uzunlu�unda bir �ifre giriniz.");
			return false;
		}
		return true;
	}

}
