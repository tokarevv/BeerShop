package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.Article;

public interface IArticleDAO {

	public void addArticle(Article article);

	public Article getArticle(Integer articleId);

	public List<Article> getAll();

	public void removeArticle(Integer id);
	
	public void updateArticle(Integer id);
	
}
