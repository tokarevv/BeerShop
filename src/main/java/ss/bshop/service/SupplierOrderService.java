package ss.bshop.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.ISupplierDAO;
import ss.bshop.dao.ISupplierOrderDAO;
import ss.bshop.domain.Supplier;
import ss.bshop.domain.SupplierOrder;

@Service
@Transactional(readOnly = true)
public class SupplierOrderService implements ISupplierOrderService{
	
	@Autowired
	private ISupplierOrderDAO supplierOrderDAO;
	
	public ISupplierOrderDAO getSupplierDAO() {
		return supplierOrderDAO;
	}

	public void setSupplierDAO(ISupplierOrderDAO supplierDAO) {
		this.supplierOrderDAO = supplierDAO;
	}

	@Transactional(readOnly = false)
	@Override
	public void add(SupplierOrder supplierOrder) {
		supplierOrderDAO.add(supplierOrder);
	}

	@Override
	public SupplierOrder get(Long id) {
		return supplierOrderDAO.get(id);
	}

	@Override
	public List<SupplierOrder> getAll() {
		return supplierOrderDAO.getAll();
	}

	@Transactional(readOnly = false)
	@Override
	public void remove(Long id) {
		supplierOrderDAO.remove(id);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(SupplierOrder supplierOrder) {
		supplierOrderDAO.update(supplierOrder);
	}

}
