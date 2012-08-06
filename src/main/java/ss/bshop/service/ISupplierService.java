package ss.bshop.service;
import java.util.List;

import ss.bshop.domain.Supplier;

public interface ISupplierService {
	
	public void add(Supplier supplier);

	public Supplier get(Long id);

	public List<Supplier> getAll();

	public void remove(Long id);
	
	public void update(Supplier supplier);

}
