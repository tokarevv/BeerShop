package ss.bshop.mobile.entities;

public class OutletOrderStructureMobile {

	private ArticleMobile article;
	private double price;
	private int amount;
	public ArticleMobile getArticle() {
		return article;
	}
	public void setArticle(ArticleMobile article) {
		this.article = article;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
