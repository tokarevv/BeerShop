package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.Article;
import ss.bshop.domain.Supplier;

public interface IArticleDAO extends ICRUDGeneral<Article, Long>{
	
	public List<Article> getBySupplier(Supplier supplier);

}
