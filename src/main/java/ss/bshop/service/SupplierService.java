package ss.bshop.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.ISupplierDAO;
import ss.bshop.domain.Supplier;

@Service
@Transactional(readOnly = true)
public class SupplierService implements ISupplierService{
	
	@Autowired
	private ISupplierDAO supplierDAO;
	
	public ISupplierDAO getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(ISupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}

	@Transactional(readOnly = false)
	@Override
	public void add(Supplier supplier) {
		supplierDAO.add(supplier);
		
	}

	@Override
	public Supplier get(Long id) {
		return (Supplier) supplierDAO.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getAll() {
		return supplierDAO.getAll();
	}

	@Transactional(readOnly = false)
	@Override
	public void remove(Long id) {
		supplierDAO.remove(id);
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void update(Supplier supplier) {
		supplierDAO.update(supplier);
	}

}
