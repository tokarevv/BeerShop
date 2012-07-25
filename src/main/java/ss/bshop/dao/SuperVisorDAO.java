/**
 * @author Kostya Tarasov
 */
package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ss.bshop.domain.SuperVisor;

@Repository("superVisorDao")
public class SuperVisorDAO implements ISuperVisorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addSuperVisor(SuperVisor superVisor) {
		sessionFactory.getCurrentSession().save(superVisor);
	}

	@Override
	public void updateSuperVisor(SuperVisor superVisor) {
		sessionFactory.getCurrentSession().update(superVisor);
	}

	@Override
	public void removeSuperVisor(Long id) {
		SuperVisor toDelete = (SuperVisor) sessionFactory.getCurrentSession().
				get(SuperVisor.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
	}

	@Override
	public SuperVisor getSuperVisor(Long id) {
		SuperVisor toReturn = (SuperVisor) sessionFactory.getCurrentSession().
				get(SuperVisor.class, id);
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SuperVisor> getAllSuperVisors() {
		List<SuperVisor> superVisors = sessionFactory.getCurrentSession().
				createQuery("from SuperVisor").list();
		return superVisors;
	}
}
