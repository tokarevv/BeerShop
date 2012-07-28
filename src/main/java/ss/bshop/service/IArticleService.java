
package ss.bshop.service;

import java.util.List;
import ss.bshop.domain.Article;
import ss.bshop.domain.Supplier;
import ss.bshop.domain.User;

/**
 *
 * @author nick
 */
public interface IArticleService {
    
    public List<Article> getArticles();

	public List<Article> getArticlesBySupplier(Supplier selectedSupplier);

	public Article getById(Long id);
        
        public void updateArticle(Article article);
    
}
