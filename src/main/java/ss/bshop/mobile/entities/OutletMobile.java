package ss.bshop.mobile.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import ss.bshop.domain.Outlet;

@Entity(name = "outlets")
public class OutletMobile {

	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String phone;
	@Column
	private Integer discount;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

}
