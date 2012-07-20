package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ss.bshop.domain.Article;


public class ArticleDAO implements IArticleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addArticle(Article article) {
		sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public Article getArticle(Long articleId) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, articleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Article")
			.list();
	}

	@Override
	public void removeArticle(Long articleId) {
		Article article = (Article) sessionFactory.getCurrentSession().load(
				Article.class, articleId);
		if (article != null) {
			sessionFactory.getCurrentSession().delete(article);
		}

	}

	@Override
	public void updateArticle(Long articleId) {
		Article article = (Article) sessionFactory.getCurrentSession().load(
				Article.class, articleId);
		if (article != null) {
			sessionFactory.getCurrentSession().delete(article);
		}
		sessionFactory.getCurrentSession().save(article);

	}

}
