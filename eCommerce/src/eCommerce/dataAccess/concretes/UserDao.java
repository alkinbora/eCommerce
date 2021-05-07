package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDaoService;
import eCommerce.entities.concretes.User;

public class UserDao implements UserDaoService{
	
	List<User> users = new ArrayList<>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName() + " adlý kullanýcý sisteme kayýt edildi.");
		
	}

	@Override
	public boolean emailCheck(User user) {
		for (User u : users)
			if (u.geteMail() == user.geteMail()) {
				return false;
		            }
		        return true;
	}

	@Override
	public boolean loginByCheck(String email, String password) {
		 for (User user : users) {
	            if (user.geteMail() == email && user.getPassword() == password)
	                return true;
	        }
	        return false;
		
	}

}
