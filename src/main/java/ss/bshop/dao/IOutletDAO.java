package ss.bshop.dao;

import java.util.List;
import ss.bshop.domain.SupplierOrder;
import org.springframework.data.repository.CrudRepository;
import ss.bshop.domain.Article;
import ss.bshop.domain.Outlet;

public interface IOutletDAO extends CrudRepository<Outlet, Long>{
	
	
        public void addOutlet(Outlet outlet);

	public Outlet getOutlet(Long articleId);

	public List<Article> getOutlet();

	public void removeOutlet(Long id);
	
	public void updateArticle(Long id);

}
