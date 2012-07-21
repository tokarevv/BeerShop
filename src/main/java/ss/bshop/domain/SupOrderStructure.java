package ss.bshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "SupOrderStructures")
public class SupOrderStructure {

@Id
@Column(name = "ID")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column
private Supplier supplier;

@Column
private Article article;	

@Column
private double price;

@Column
private double amount;
	
	
//getters and setters
public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
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


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(amount);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((article == null) ? 0 : article.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SupOrderStructure other = (SupOrderStructure) obj;
	if (Double.doubleToLongBits(amount) != Double
			.doubleToLongBits(other.amount))
		return false;
	if (article == null) {
		if (other.article != null)
			return false;
	} else if (!article.equals(other.article))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	if (supplier == null) {
		if (other.supplier != null)
			return false;
	} else if (!supplier.equals(other.supplier))
		return false;
	return true;
}

}

