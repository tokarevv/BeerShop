package ss.bshop.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ss.bshop.dao.ISupOrderStructDAO;

import ss.bshop.domain.SupOrderStructure;

@Repository
public class SupOrderStructDAO implements ISupOrderStructDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(SupOrderStructure structure) {
		sessionFactory.getCurrentSession().save(structure);
	}

	@Override
	public SupOrderStructure get(Long id) {
		return (SupOrderStructure) sessionFactory.getCurrentSession().get(
				SupOrderStructure.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupOrderStructure> getAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from SupOrderStructure").list();
	}

	@Override
	public void remove(Long id) {
		SupOrderStructure structure = (SupOrderStructure) sessionFactory
				.getCurrentSession().load(SupOrderStructure.class, id);
		if (structure != null) {
			sessionFactory.getCurrentSession().delete(structure);
		}
	}

	@Override
	public void update(SupOrderStructure structure) {
		sessionFactory.getCurrentSession().update(structure);
		
	}


}
