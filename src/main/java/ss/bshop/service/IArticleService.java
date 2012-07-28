
package ss.bshop.service;

import java.util.List;
import ss.bshop.domain.Article;
import ss.bshop.domain.Supplier;

/**
 *
 * @author nick
 */
public interface IArticleService {
    
    public List<Article> getArticles();

	public List<Article> getArticlesBySupplier(Supplier selectedSupplier);

	public Article getById(Long id);
	
	public void add(Article article);

	public void remove(Long id);
	
	public void update(Article article);
    
}
