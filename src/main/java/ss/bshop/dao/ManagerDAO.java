/**
 * @author Kostya Tarasov
 */
package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ss.bshop.domain.Manager;

@Repository
public class ManagerDAO implements IManagerDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addManager(Manager manager) {
		sessionFactory.getCurrentSession().save(manager);
	}

	@Override
	public void updateManager(Manager manager) {
		sessionFactory.getCurrentSession().update(manager);
	}

	@Override
	public void removeManager(Long id) {
		Manager toDelete = (Manager) sessionFactory.getCurrentSession().
				get(Manager.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
	}

	@Override
	public Manager getManager(Long id) {
		Manager toReturn = (Manager) sessionFactory.getCurrentSession().
				get(Manager.class, id);
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> getAllManagers() {
		List<Manager> managers = sessionFactory.getCurrentSession().
				createQuery("from Manager").list();
		return managers;
	}
}