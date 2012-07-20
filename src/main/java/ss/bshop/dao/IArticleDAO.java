package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.Article;

public interface IArticleDAO {

	public void addArticle(Article article);

	public Article getArticle(Long articleId);

	public List<Article> getAll();

	public void removeArticle(Long id);
	
	public void updateArticle(Long id);
	
}
