package ss.bshop.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ss.bshop.domain.Article;


@Repository
public class ArticleDAO implements IArticleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Article article) {
		sessionFactory.getCurrentSession().saveOrUpdate(article);
	}

	@Override
	public Article get(Long articleId) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, articleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Article")
			.list();
	}

	@Override
	public void remove(Long id) {
		Article article = (Article) sessionFactory.getCurrentSession().load(
				Article.class, id);
		if (article != null) {
			sessionFactory.getCurrentSession().delete(article);
		}
	}

	@Override
	public void update(Article article) {
		sessionFactory.getCurrentSession().update(article);
	}

}
