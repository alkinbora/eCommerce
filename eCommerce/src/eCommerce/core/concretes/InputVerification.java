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
			System.out.println("Girdiðiniz e-mail geçersizdir.");
			System.out.println("Lütfen geçerli bir e-mail adresi giriniz!");
			return false;
		}
		if(!isValidName(user.getFirstName())) {
			System.out.println("Adýnýzý yanlýþ girdiniz. Lütfen en az iki karekter ve sayý içermeyen bir ad giriniz.");
			return false;
		}
		if(!isValidName(user.getLastName())) {
			System.out.println("Soyadýnýzý yanlýþ girdiniz. Lütfen en az iki karekter ve sayý içermeyen bir soyad giriniz.");
			return false;
		}
		if(!isValidPassword(user.getPassword())) {
			System.out.println("Geçersiz parola. Lütfen en az 6 karakter uzunluðunda bir þifre giriniz.");
			return false;
		}
		return true;
	}

}
