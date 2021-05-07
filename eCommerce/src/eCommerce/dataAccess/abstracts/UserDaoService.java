package eCommerce.dataAccess.abstracts;

import eCommerce.entities.concretes.User;

public interface UserDaoService {

	void add(User user);
	boolean emailCheck(User user);
	boolean loginByCheck(String email, String password);
}
