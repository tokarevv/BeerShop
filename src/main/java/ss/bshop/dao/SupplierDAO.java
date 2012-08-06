package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.domain.Supplier;

@Repository
public class SupplierDAO implements ISupplierDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly = false)
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

	@Transactional(readOnly = false)
	@Override
	public void remove(Long id) {
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().load(
				Supplier.class, id);
		if (supplier != null) {
			sessionFactory.getCurrentSession().delete(supplier);
		}
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void update(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
	}

}
