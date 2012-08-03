package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.ISupOrderStructDAO;
import ss.bshop.domain.SupOrderStructure;

@Service
@Transactional(readOnly = true)
public class SupplierOrderStructureService implements ISupplierOrderStructureService{
	
	@Autowired
	private ISupOrderStructDAO supplierOrderStructureDAO;
	
	public ISupOrderStructDAO getSupplierDAO() {
		return supplierOrderStructureDAO;
	}

	public void setSupplierDAO(ISupOrderStructDAO supplierOrderStructureDAO) {
		this.supplierOrderStructureDAO = supplierOrderStructureDAO;
	}

	@Transactional(readOnly = false)
	@Override
	public void add(SupOrderStructure orderStructure) {
		supplierOrderStructureDAO.add(orderStructure);
	}

	@Override
	public SupOrderStructure get(Long orgerId) {
		return supplierOrderStructureDAO.get(orgerId);
	}

	@Override
	public List<SupOrderStructure> getAll() {
		return supplierOrderStructureDAO.getAll();
	}

	@Transactional(readOnly = false)
	@Override
	public void remove(Long id) {
		supplierOrderStructureDAO.remove(id);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(SupOrderStructure orderStructure) {
		supplierOrderStructureDAO.update(orderStructure);
	}


}
