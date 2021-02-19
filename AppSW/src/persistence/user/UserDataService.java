package persistence.user;

import model.User;

public interface UserDataService {
	
	public boolean saveUser(User user);
	
	public User getUserByUsernameAndPassword(User user, String password);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
}
