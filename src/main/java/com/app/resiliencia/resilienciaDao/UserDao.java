package com.app.resiliencia.resilienciaDao;
import java.util.List;

import com.app.resiliencia.model.*;
public interface UserDao {

	public List<User> getUsers();
	public User getUserById(Integer id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(Integer id);
	public User userAllowed(String name, String pwd);
	
	
}
