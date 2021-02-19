package business.usermanager;

import model.User;

public interface UserManagerService {

	public boolean saveUser(User user);
	
	public User getUserByEmailAndPassword(String email, String password);
	
	public boolean deleteUser(Long id);
}
