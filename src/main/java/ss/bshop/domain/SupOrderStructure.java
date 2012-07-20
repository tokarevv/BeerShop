package ss.bshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "SupOrderStructures")
public class SupOrderStructure {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column
private Supplier supplier;

@Column
private Article article;	

@Column
private double price;

@Column
private int amount;
	
	
//getters and setters
public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public Article getArticle() {
	return article;
}

public void setArticle(Article article) {
	this.article = article;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public Supplier getSupplier() {
	return supplier;
}

public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

}

