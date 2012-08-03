package ss.bshop.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.test.context.ContextConfiguration;

import ss.bshop.domain.Article;
import ss.bshop.domain.Supplier;

@ContextConfiguration("test-context.xml")
public class Main {

	private final static String[][] names = {
			{ "Chernigiv", "2" },
			{ "Rogan", "3" },
			{ "Stella Artois", "3" },
			{ "Pillsner", "5" } };
	private final static String[] kinds = { "light", "dark", "lager", "premium" };

	public static void generateArticles() {

		for (String[] name : names) {
//			Supplier supplier = getNewSupplier(name[1]);
//			// daoSup.add(supplier);
//			System.out
//					.println("insert into Supplier (INN, OKPO, address, comment, email, name, phone, svidNumber) values ("
//							+ "'"
//							+ supplier.getINN()
//							+ "',"
//							+ "'"
//							+ supplier.getOKPO()
//							+ "',"
//							+ "'"
//							+ supplier.getAddress()
//							+ "',"
//							+ "'"
//							+ supplier.getComment()
//							+ "',"
//							+ "'"
//							+ supplier.getEmail()
//							+ "',"
//							+ "'"
//							+ supplier.getName()
//							+ "',"
//							+ "'"
//							+ supplier.getPhone()
//							+ "',"
//							+ "'"
//							+ supplier.getSvidNumber() + "'" + ")");
			for (String kind : kinds) {
				Article article = getNewArticle(name[0], kind);
				System.out.println("insert into Article (barcode, comment, name, percent, price, quantity, Supplier_id, type, unit) values ("+
						"'"+ article.getBarcode() + "'," + 
						"'"+ article.getComment() + "'," + 
						"'"+ article.getName() + "'," + 
						""+ article.getPercent() + "," + 
						""+ article.getPrice() + "," + 
						""+ article.getQuantity() + "," + 
						""+ name[1] + "," + 
						"'pivo'," + 
						"'pack'" + 
						");");

				// daoI.add(article);
			}
		}

	}

	private static Article getNewArticle(String name, String kind) {
		Article res = new Article();
		res.setBarcode("" + (long) (Math.random() * 999999999999l));
		res.setName(name+" "+kind);
		res.setPercent(30);
		res.setPrice(new BigDecimal(4 + Math.random() * 4).setScale(2,
				RoundingMode.UP).doubleValue());
		res.setQuantity((int) (Math.random() * 100));
		res.setUnit("ящ");

		return res;
	}

	private static Supplier getNewSupplier(String name) {
		Supplier res = new Supplier();
		res.setName(name);
		res.setAddress("" + (int) (Math.random() * 100)
				+ ", Somestreet, SomeCity, " + (int) (Math.random() * 99999));
		res.setEmail("email@domen.name");
		res.setINN("" + (long) (Math.random() * 999999999999l));
		res.setOKPO("" + (long) (Math.random() * 99999999));
		res.setPhone("" + (long) (Math.random() * 9999999));
		res.setSvidNumber("" + (long) (Math.random() * 99999999));

		return res;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// System.out.println("msin");
		// File f = new File("s");
		// System.out.println(f.getCanonicalPath());

		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext("test-context.xml");
		// String[] beanNames = context.getBeanDefinitionNames();
		//
		// for (String s : beanNames){
		// System.out.println(s);
		// }
		// context.getBean("Autogenertion")
		generateArticles();

		// Fill fill = new Fill();
		// fill.createUsers();

	}

}
