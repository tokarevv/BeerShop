package ss.bshop.dao;

import java.io.Serializable;
import java.util.List;

import ss.bshop.domain.Manager;

public interface IManagerDAO extends Serializable{
	public void addManager(Manager manager);
	public void updateManager(Manager manager);
	public void removeManager(Long id);
	public Manager getManager(Long id);
	public List<Manager> getAllManagers();
	public Manager getByLogin(String login);
}
