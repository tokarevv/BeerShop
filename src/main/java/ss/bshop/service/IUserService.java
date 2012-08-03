package ss.bshop.service;

import java.util.List;

import ss.bshop.domain.Manager;
import ss.bshop.domain.SalesRep;
import ss.bshop.domain.SuperVisor;
import ss.bshop.domain.User;


/**
 * 
 * User Service Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface IUserService {
	
	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	public void addUser(User user);
	
	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	public void updateUser(User user);

	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	public void deleteUser(User user);
	
	/**
	 * Get User
	 * 
	 * @param  int User Id
	 */
	public User getUserById(int id);
	
	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<User> getUsers();
	
	public Manager managerByUserId(Long id);
	public SuperVisor supervisorByUserId(Long id);
	public SalesRep salesrepByUserId(Long id);
}
