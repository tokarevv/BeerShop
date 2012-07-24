package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ss.bshop.domain.SupplierOrder;


public class SupplierOrderDAO implements ISupplierOrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(SupplierOrder order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public SupplierOrder get(Long orgerId) {
		return (SupplierOrder) sessionFactory.getCurrentSession().get(SupplierOrder.class, orgerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplierOrder> getAll() {

		return sessionFactory.getCurrentSession().createQuery("from SupplierOrder")
			.list();
		
	}

	@Override
	public void remove(Long id) {
		SupplierOrder oreder = (SupplierOrder) sessionFactory.getCurrentSession().load(
				SupplierOrder.class, id);
		if (oreder != null) {
			sessionFactory.getCurrentSession().delete(oreder);
		}
		
	}

	@Override
	public void update(Long id) {
		SupplierOrder order = (SupplierOrder) sessionFactory.getCurrentSession().load(
				SupplierOrder.class, id);
		if (order != null) {
			sessionFactory.getCurrentSession().delete(order);
		}
		sessionFactory.getCurrentSession().save(order);
		
	}

}
