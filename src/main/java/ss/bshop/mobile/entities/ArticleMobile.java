package ss.bshop.mobile.entities;

import ss.bshop.domain.Article;

public class ArticleMobile {

	private Long id;
	private String name;
	private String type;
	private Double price;
	private int qty;
	private String unit;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public static ArticleMobile fromArticle(Article article) {
		ArticleMobile am = new ArticleMobile();
		am.setId(article.getId());
		am.setName(article.getName());
		am.setType(article.getType());
		am.setPrice(article.getPrice());
		am.setQty(article.getQuantity());
		am.setUnit(article.getUnit());
		return am;
	}
}
