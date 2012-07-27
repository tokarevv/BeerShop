/**
 * @author Kostya Tarasov
 */
package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.User;

public interface IUserDAO {
	public void addUser(User user);
	public void updateUser(User user);
	public void removeUser(Long id);
	public User getUser(Long id);
	public List<User> getAllUsers();
}
