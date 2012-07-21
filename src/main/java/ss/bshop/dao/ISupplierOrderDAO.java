package ss.bshop.dao;

import java.util.List;
import ss.bshop.domain.SupplierOrder;

public interface ISupplierOrderDAO {
	
	public void add(SupplierOrder order);

	public SupplierOrder get(Long orgerId);

	public List<SupplierOrder> getAll();

	public void remove(Long id);
	
	public void update(Long id);
}
