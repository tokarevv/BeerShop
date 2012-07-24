package ss.bshop.domain;

import java.util.Date;

public class GenereateObjectHelper {
	
	public static Article getNewArticle(){
		Article article = new Article();
		article.setName("Article"+getRandomInt());
		article.setBarcode("831418518");
		
		
		return article;
	}

	public static SupOrderStructure getNewSupOrderStructure(){
    	SupOrderStructure order = new SupOrderStructure();
		order.setAmount(234);
		order.setPrice(12);
		order.setArticle(getNewArticle());
		order.setSupplierOrder(getNewSupplierOrder());
		return order;
	}

	public static SupplierOrder getNewSupplierOrder(){
		SupplierOrder order = new SupplierOrder();
		order.setOrderDate(new Date());
		order.setStatus(true);
		return order;
	}

	private static int getRandomInt() {
		return (int) (Math.random()*99999999);
	}

}
