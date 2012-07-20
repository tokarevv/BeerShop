package ss.bshop.domain;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "SupplierOrders")
public class SupplierOrder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String type; // order-return

	// TODO getters/setters, generate hashCode, equals	
//	@Column
//	private Manager manager;
	
	@Column
	private String orderDate;
	
	@Column
	private String orderDoneDate;
	
	@Column
	private String comment;
	
	@Column
	private Boolean status; // dispatched/not-dispatched
	
	@Column
	private List<SupOrderStructure> orderstruct;
	 	 		
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
	
	public List<SupOrderStructure> getOrderstruct() {
		return orderstruct;
	}
	public void setOrderstruct(List<SupOrderStructure> orderstruct) {
		this.orderstruct = orderstruct;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
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
	
}
