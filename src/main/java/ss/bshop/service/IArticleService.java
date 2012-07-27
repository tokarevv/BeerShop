
package ss.bshop.service;

import java.util.List;
import ss.bshop.domain.Article;
import ss.bshop.domain.User;

/**
 *
 * @author nick
 */
public interface IArticleService {
    
    public List<Article> getArticles();
    public Article getById(Long id);
    
}
