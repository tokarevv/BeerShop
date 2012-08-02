package ss.bshop.gen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IArticleDAO;
import ss.bshop.dao.ISupplierDAO;
import ss.bshop.domain.Article;
import ss.bshop.domain.Supplier;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * author: Victor
 */
@Transactional
public class Autogenertion {

    @Autowired
    private static IArticleDAO daoI;

    @Autowired
    private static ISupplierDAO daoSup;
    
    
    private static final String[][] names = {
    	{"Chernigiv","Черниговский завод"},
    	{"Rogan","Запорожский завод"},
    	{"Stella Artois","Запорожский завод"},
    	{"Pillsner", "Полтавская броварня"}
    };
    private static final String[] kinds = {"light","dark","lager","premium"};
    

    /**
     * Method: add(Article article)
     */
	public static void generateArticles() {
    	
    	for (String[] name : names){
    		Supplier supplier = getNewSupplier(name[1]);
    		daoSup.add(supplier);
    		for (String kind : kinds){
    			Article article = getNewArticle(name[0], kind, supplier);
    			daoI.add(article);
    		}
    	}
    	
	}


	private static Article getNewArticle(String name, String kind, Supplier supplier) {
		Article res = new Article();
		res.setBarcode(""+(long)(Math.random()*999999999999l));
		res.setName(name);
		res.setPercent(30);
		res.setPrice(new BigDecimal(4+Math.random()*4).setScale(2, RoundingMode.UP).doubleValue());
		res.setQuantity((int)(Math.random()*100));
		res.setSupplier(supplier);
		res.setUnit("ящ");

		return res;
	}


	private static Supplier getNewSupplier(String name) {
		Supplier res = new Supplier();
		res.setName(name);
		res.setAddress(""+(int)(Math.random()*100)+", Somestreet, SomeCity, "+(int)(Math.random()*99999));
		res.setEmail("email@domen.name");
		res.setINN(""+(long)(Math.random()*999999999999l));
		res.setOKPO(""+(long)(Math.random()*99999999));
		res.setPhone(""+(long)(Math.random()*9999999));
		res.setSvidNumber(""+(long)(Math.random()*99999999));
		
		return res;
	}
    
    

}  
