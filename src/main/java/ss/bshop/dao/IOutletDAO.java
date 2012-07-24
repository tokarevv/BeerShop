package ss.bshop.dao;

import java.io.Serializable;
import java.util.List;
import ss.bshop.domain.SupplierOrder;
import org.springframework.data.repository.CrudRepository;
import ss.bshop.domain.Article;
import ss.bshop.domain.Outlet;

public interface IOutletDAO extends ICRUDGeneral <Outlet, Long>{
	

}
