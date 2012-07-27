package ss.bshop.domain;

import javax.persistence.*;

@Entity
public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column
    private String type;

    @Column
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Supplier_id")
    private Supplier supplier;

    @Column
    private String unit;

    @Column
    private String barcode;

    @Column
    private String comment;

    //constructors
    public Article() {
    }
    
    public Article(String name) {
        this.name = name;
    }
    
    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }
    public Supplier getSupplier() {
            return supplier;
    }
    public void setSupplier(Supplier suplier) {
            this.supplier = suplier;
    }
    public String getUnit() {
            return unit;
    }
    public void setUnit(String unit) {
            this.unit = unit;
    }
    public String getBarcode() {
            return barcode;
    }
    public void setBarcode(String barcode) {
            this.barcode = barcode;
    }
    public String getComment() {
            return comment;
    }
    public void setComment(String comment) {
            this.comment = comment;
    }
    
    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Article other = (Article) obj;
            if (barcode == null) {
                    if (other.barcode != null)
                            return false;
            } else if (!barcode.equals(other.barcode))
                    return false;
            if (comment == null) {
                    if (other.comment != null)
                            return false;
            } else if (!comment.equals(other.comment))
                    return false;
            if (id == null) {
                    if (other.id != null)
                            return false;
            } else if (!id.equals(other.id))
                    return false;
            if (name == null) {
                    if (other.name != null)
                            return false;
            } else if (!name.equals(other.name))
                    return false;
            if (price == null) {
                    if (other.price != null)
                            return false;
            } else if (!price.equals(other.price))
                    return false;
            if (supplier == null) {
                    if (other.supplier != null)
                            return false;
            } else if (!supplier.equals(other.supplier))
                    return false;
            if (type == null) {
                    if (other.type != null)
                            return false;
            } else if (!type.equals(other.type))
                    return false;
            if (unit == null) {
                    if (other.unit != null)
                            return false;
            } else if (!unit.equals(other.unit))
                    return false;
            return true;
    }

    @Override
	public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
            result = prime * result + ((comment == null) ? 0 : comment.hashCode());
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((price == null) ? 0 : price.hashCode());
            result = prime * result
                            + ((supplier == null) ? 0 : supplier.hashCode());
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            result = prime * result + ((unit == null) ? 0 : unit.hashCode());
            return result;
    }

	@Override
	public String toString() {
		return "Article [" + (id != null ? "id=" + id + ", " : "")
				+ (name != null ? "name=" + name + ", " : "")
				+ (type != null ? "type=" + type + ", " : "")
				+ (price != null ? "price=" + price + ", " : "")
				+ (supplier != null ? "supplier=" + supplier + ", " : "")
				+ (unit != null ? "unit=" + unit + ", " : "")
				+ (barcode != null ? "barcode=" + barcode + ", " : "")
				+ (comment != null ? "comment=" + comment : "") + "]";
	}
    
    
	
        
}
