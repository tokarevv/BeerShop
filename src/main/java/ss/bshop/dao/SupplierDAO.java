package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ss.bshop.domain.Supplier;


public class SupplierDAO implements ISupplierDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Supplier supplier) {
		sessionFactory.getCurrentSession().save(supplier);
		
	}

	@Override
	public Supplier get(Long id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier")
				.list();
	}

	@Override
	public void remove(Long id) {
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().load(
				Supplier.class, id);
		if (supplier != null) {
			sessionFactory.getCurrentSession().delete(supplier);
		}
		
	}

	@Override
	public void update(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
	}

}
