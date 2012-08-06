package ss.bshop.dao;

import java.util.Date;
import ss.bshop.domain.Article;
import ss.bshop.domain.Outlet;
import ss.bshop.domain.OutletOrder;
import ss.bshop.domain.SalesRep;
import ss.bshop.domain.SupOrderStructure;
import ss.bshop.domain.Supplier;
import ss.bshop.domain.SupplierOrder;
import ss.bshop.domain.User;
import ss.bshop.domain.Visit;

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
		order.setSupplier(getNewSupplier());
		return order;
	}

	public static OutletOrder getNewOutletOrder(){
		OutletOrder order = new OutletOrder();
		order.setVisit(new Visit());
		return order;
	}

	private static int getRandomInt() {
		return (int) (Math.random()*99999999);
	}

	public static Supplier getNewSupplier() {
		Supplier res = new Supplier();
		res.setName("Supplier"+getRandomInt());
		return res;
	}

	public static Outlet getNewOutlet() {
		Outlet res = new Outlet();
		res.setName("Outlet"+getRandomInt());
		return res;
	}

	public static SalesRep getNewSalesRep() {
		SalesRep res = new SalesRep();
		res.setUser(getNewUser());
		return res;
	}

	public static User getNewUser() {
		User res = new User();
		res.setFullname("VasyaPupkigs");
		res.setLogin("vvv");
		res.setPost("srs");
		return res;
	}

}
