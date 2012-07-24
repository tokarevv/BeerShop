package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ss.bshop.domain.Visit;

@Repository
public class VisitDAO implements IVisitDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Visit visit) {
		sessionFactory.getCurrentSession().save(visit);
	}

	@Override
	public Visit get(Long visitId) {
		return (Visit) sessionFactory.getCurrentSession().get(Visit.class, visitId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> getAll() {

		return sessionFactory.getCurrentSession().createQuery("from Visit")
			.list();
		
	}

	@Override
	public void remove(Long id) {
		Visit visit = (Visit) sessionFactory.getCurrentSession().load(
				Visit.class, id);
		if (visit != null) {
			sessionFactory.getCurrentSession().delete(visit);
		}
		
	}

	@Override
	public void update(Long id) {
		Visit visit = (Visit) sessionFactory.getCurrentSession().load(
				Visit.class, id);
		if (visit != null) {
			sessionFactory.getCurrentSession().delete(visit);
		}
		sessionFactory.getCurrentSession().save(visit);
		
	}

}
