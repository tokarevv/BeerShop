package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ss.bshop.dao.IArticleDAO;

import ss.bshop.domain.Article;
import ss.bshop.domain.Supplier;


/**
 * 
 * Article Service
 *
 */
@Service
@Transactional(readOnly = true)
public class ArticleService implements IArticleService {

	@Autowired
	IArticleDAO articleDAO;

        @Override
        public List<Article> getArticles() {
            return articleDAO.getAll();
        }

        @Override
        public List<Article> getArticlesBySupplier(Supplier supplier) {
                return articleDAO.getBySupplier(supplier);
        }

        public Article getById(Long id) {
                return articleDAO.get(id);
        }

        @Transactional(readOnly = false)
        @Override
        public void add(Article article) {
                articleDAO.add(article);

        }

        @Transactional(readOnly = false)
        @Override
        public void remove(Long id) {
                articleDAO.remove(id);
        }

        @Transactional(readOnly = false)
        @Override
        public void update(Article article) {
                articleDAO.update(article);

        }

}
