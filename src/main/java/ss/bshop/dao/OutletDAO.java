/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class OutletDAO implements IOutletDAO{
    @Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addOutlet(Outlet article) {
		sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public Article getOutlet(Long articleId) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, articleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Outlet> getAll() {
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

