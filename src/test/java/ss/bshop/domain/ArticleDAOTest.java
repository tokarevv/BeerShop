package ss.bshop.domain;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IArticleDAO;
import ss.bshop.domain.Article;

import java.util.List;

/**
 * ArticleDAO Tester. 
 * 
 * author: Victor
 */
@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ArticleDAOTest {

    @Autowired
    private IArticleDAO daoI;

    /**
     * Method: add(Article article)
     */
    @Test
	public void testAdd() throws Exception {
		Article article = new Article();
		article.setName("Snicks");
		article.setBarcode("831418518");

		//System.out.println(article);
		daoI.add(article);
		List<Article> articleList = daoI.getAll();

		// for(Article a : articleList){
		// System.out.println(a);
		// }

		Assert.assertEquals(article, articleList.get(articleList.size() - 1));
		Assert.assertEquals(article.getName(),
				articleList.get(articleList.size() - 1).getName());
	}
    
    /**
     * Method: getArticle(Integer articleId)
     */
    @Test
	public void testGetArticle() throws Exception {

		Article article = new Article();
		article.setName("S");

		daoI.add(article);
		List<Article> articleList = daoI.getAll();

		Article loadedArticle = articleList.get(articleList.size() - 1);
		Long loadedArticleId = loadedArticle.getId();
		Assert.assertEquals(loadedArticle, daoI.get(loadedArticleId));
	}
    

}  
