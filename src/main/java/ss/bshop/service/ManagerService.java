package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IManagerDAO;
import ss.bshop.domain.Manager;

@Service
@Transactional(readOnly = true)
public class ManagerService implements IManagerService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IManagerDAO managerDAO;
	
	
	public IManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(IManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	@Transactional(readOnly = false)
	@Override
	public void add(Manager manager) {
		managerDAO.addManager(manager);
		
	}

	@Override
	public Manager get(Long id) {
		return (Manager) managerDAO.getManager(id);
	}

	@Override
	public List<Manager> getAll() {
		return managerDAO.getAllManagers();
	}

	@Transactional(readOnly = false)
	public void remove(Long id) {
		managerDAO.removeManager(id);
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void update(Manager manager) {
		managerDAO.updateManager(manager);
	}

	@Override
	public Manager getByLogin(String login) {
		return managerDAO.getByLogin(login);
	}

}
