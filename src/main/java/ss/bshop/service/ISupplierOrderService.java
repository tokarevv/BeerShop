package ss.bshop.service;

import java.util.List;

import ss.bshop.domain.SupplierOrder;

public interface ISupplierOrderService {
	
	public void add(SupplierOrder supplierOrder);

	public SupplierOrder get(Long id);

	public List<SupplierOrder> getAll();

	public void remove(Long id);
	
	public void update(SupplierOrder supplierOrder);

}
