
package ss.bshop.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ss.bshop.domain.Article;
import ss.bshop.domain.Outlet;

/**
 *
 * @author nick
 */
@Repository
public class OutletDAO {
        
        @Autowired
        private IOutletDAO repository;

	public void addOutlet(Outlet outlet) {
            repository.save(outlet);
            
            
	}

	public Outlet getArticle(Long articleId) {
		return repository.findOne(articleId);
	}

//	@SuppressWarnings("unchecked")
//	public List<Outlet> getAll() {
//		
//           
//	}

	public void removeOutlet(Long articleId) {
		

	}

	public void updateOutlet(Long articleId) {
		

	}
}

