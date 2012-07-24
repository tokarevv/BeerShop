package ss.bshop.dao;

import java.util.List;
import ss.bshop.domain.SupplierOrder;
import org.springframework.data.repository.CrudRepository;
import ss.bshop.domain.Outlet;

public interface IOutletDAO extends CrudRepository<Outlet, Long>{
	List<Outlet> findByName(String name);

}
