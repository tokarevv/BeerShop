package ss.bshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IManagerDAO;
import ss.bshop.dao.ISalesRepDAO;
import ss.bshop.dao.ISuperVisorDAO;
import ss.bshop.dao.IUserDAO;
import ss.bshop.domain.Manager;
import ss.bshop.domain.SalesRep;
import ss.bshop.domain.SuperVisor;
import ss.bshop.domain.User;


/**
 * 
 * User Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Service
@Transactional(readOnly = true)
public class UserService implements IUserService {

	// UserDAO is injected...
	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IManagerDAO managerDAO;
	
	@Autowired
	ISalesRepDAO salesrepDAO;
	
	@Autowired
	ISuperVisorDAO supervisorDAO;
	
	public ISalesRepDAO getSalesrepDAO() {
		return salesrepDAO;
	}

	public void setSalesrepDAO(ISalesRepDAO salesrepDAO) {
		this.salesrepDAO = salesrepDAO;
	}

	public ISuperVisorDAO getSupervisorDAO() {
		return supervisorDAO;
	}

	public void setSupervisorDAO(ISuperVisorDAO supervisorDAO) {
		this.supervisorDAO = supervisorDAO;
	}

	public IManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(IManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	@Override
	public void addUser(User user) {
		getUserDAO().addUser(user);
	}

	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteUser(User user) {
		getUserDAO().removeUser(user.getId());
	}
	
	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}
	
	/**
	 * Get User
	 * 
	 * @param  int User Id
	 */
	@Override
	public User getUserById(int id) {
		return getUserDAO().getUser((long) id);
	}

	/**
	 * Get User List
	 * 
	 */
	@Override
	public List<User> getUsers() {	
		return getUserDAO().getAllUsers();
	}

	/**
	 * Get User DAO
	 * 
	 * @return IUserDAO - User DAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Set User DAO
	 * 
	 * @param IUserDAO - User DAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public Manager managerByUserId(Long id){
		int index=0;
		List<Manager> managList=new ArrayList<Manager>();
		managList=getManagerDAO().getAllManagers();
		Manager man=null;
		for(Manager manager:managList){
			if (id.equals(manager.getUser().getId())){
				index++;
				man=manager;
			}
		}
		return man;
	}

	@Override
	public SuperVisor supervisorByUserId(Long id) {
		List<SuperVisor> superList=new ArrayList<SuperVisor>();
		superList=getSupervisorDAO().getAllSuperVisors();
		SuperVisor superv=null;
		for(SuperVisor supervisor:superList){
			if (id.equals(supervisor.getUser().getId())){
				superv=supervisor;
			}
		}
		return superv;
	}

	@Override
	public SalesRep salesrepByUserId(Long id) {
		List<SalesRep> salesList=new ArrayList<SalesRep>();
		salesList=getSalesrepDAO().getAllSalesReps();
		SalesRep salesrep=null;
		for(SalesRep tmp:salesList){
			if (id.equals(tmp.getUser().getId())){
				salesrep=tmp;
			}
		}
		return salesrep;
	}
	
	

}
