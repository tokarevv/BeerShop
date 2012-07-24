package ss.bshop.dao;
import java.util.List;

import ss.bshop.domain.Supplier;

public interface ISupplierDAO {
	
	public void add(Supplier supplier);

	public Supplier get(Long id);

	public List<Supplier> getAll();

	public void remove(Long id);
	
	public void update(Supplier supplier);

}
