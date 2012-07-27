package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ss.bshop.dao.IArticleDAO;

import ss.bshop.domain.Article;


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
		public Article getById(Long id) {
			return articleDAO.get(id);
		}

}
