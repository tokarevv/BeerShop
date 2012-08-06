package ss.bshop.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "SupplierOrders")
public class SupplierOrder {
	
	public static final String ORDER = "order";
	public static final String RETURN = "return";
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String type; // order-return

	@ManyToOne
	private Manager manager;
	
	@Column
	@Temporal( value = TemporalType.TIMESTAMP ) 
    private Date orderDate;
	
	@Column
	private String orderDoneDate;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)
	private Supplier supplier;
	
	@Column
	private String comment;
	
	@Column
	private Boolean status; // dispatched/not-dispatched
	
//	@OneToMany
//	private List<SupOrderStructure> orderstruct;
//	 	 		
//	public List<SupOrderStructure> getOrderstruct() {
//		return orderstruct;
//	}
//	public void setOrderstruct(List<SupOrderStructure> orderstruct) {
//		this.orderstruct = orderstruct;
//	}
	//getters and setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderDoneDate() {
		return orderDoneDate;
	}
	public void setOrderDoneDate(String orderDoneDate) {
		this.orderDoneDate = orderDoneDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
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
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result
				+ ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result
				+ ((orderDoneDate == null) ? 0 : orderDoneDate.hashCode());
//		result = prime * result
//				+ ((orderstruct == null) ? 0 : orderstruct.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SupplierOrder other = (SupplierOrder) obj;
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
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderDoneDate == null) {
			if (other.orderDoneDate != null)
				return false;
		} else if (!orderDoneDate.equals(other.orderDoneDate))
			return false;
//		if (orderstruct == null) {
//			if (other.orderstruct != null)
//				return false;
//		} else if (!orderstruct.equals(other.orderstruct))
//			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return true;
	}
	
}
