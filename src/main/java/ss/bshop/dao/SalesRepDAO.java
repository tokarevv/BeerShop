/**
 * @author Kostya Tarasov
 */
package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ss.bshop.domain.SalesRep;

@Repository("salesRepDao")
public class SalesRepDAO implements ISalesRepDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addSalesRep(SalesRep salesRep) {
		sessionFactory.getCurrentSession().save(salesRep);
	}

	@Override
	public void updateSalesRep(SalesRep salesRep) {
		sessionFactory.getCurrentSession().update(salesRep);
	}

	@Override
	public void removeSalesRep(Long id) {
		SalesRep toDelete = (SalesRep) sessionFactory.getCurrentSession().
				get(SalesRep.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
	}

	@Override
	public SalesRep getSalesRep(Long id) {
		SalesRep toReturn = (SalesRep) sessionFactory.getCurrentSession().
				get(SalesRep.class, id);
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalesRep> getAllSalesReps() {
		List<SalesRep> salesReps = sessionFactory.getCurrentSession().
				createQuery("from SalesRep").list();
		return salesReps;
	}
}
