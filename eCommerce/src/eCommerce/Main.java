package eCommerce;

import eCommerce.business.abstracts.UserService;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.concretes.EmailValidatorManager;
import eCommerce.core.concretes.InputVerification;
import eCommerce.core.concretes.JGoogleUserVerificationServiceAdepter;
import eCommerce.dataAccess.concretes.UserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User(1, "Engin", "Demiroð", "engindemiro@gmail.com", "123456");
		User user2 = new User(2, "Ege", "Aytaç", "egemel@hotmail.com", "");
		User user3 = new User(3, "Serhat", "","serhatdokumaci@hotmail.com", "987654");
		User user4 = new User(4, "Alkýn Bora", "Uçak", "alkinbora287@gmail.com", "123456");
		User user5 = new User(5, "Kerem", "Varýþ", "alkinbora287@gmail.com", "123456");
		
		UserService userService = new UserManager(new InputVerification(), new UserDao(), new EmailValidatorManager());
		userService.register(user3);
		System.out.println("-------------------------------------------");
		userService.register(user2);
		System.out.println("-------------------------------------------");
		userService.register(user4);
		System.out.println("-------------------------------------------");
		userService.register(user5);
		System.out.println("-------------------------------------------");
		
		UserService userService2 = new UserManager(new JGoogleUserVerificationServiceAdepter(), new UserDao(), new EmailValidatorManager());
		userService2.register(user1);
		System.out.println("-------------------------------------------");
		
		userService.login("serhatdokumaci@hotmail.com", "123456");
		System.out.println("-------------------------------------------");
		userService.login("alkinbora287@gmail.com", "123456");
		System.out.println("-------------------------------------------");
		
	}

}
