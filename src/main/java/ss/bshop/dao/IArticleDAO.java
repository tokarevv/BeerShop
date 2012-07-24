package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.Article;

public interface IArticleDAO {

	public void add(Article article);

	public Article get(Long articleId);

	public List<Article> getAll();

	public void remove(Long id);
	
	public void update(Article article);
	
}
