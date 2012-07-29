package ss.bshop.mobile.entities;

import ss.bshop.domain.Outlet;

public class OutletMobile {

	private Long id;
	private String name;
	private String address;
	private String phone;
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
	public static OutletMobile fromOutlet(Outlet outlet) {
		OutletMobile om = new OutletMobile();
		om.setId(outlet.getId());
		om.setName(outlet.getName());
		om.setAddress(outlet.getAddress());
		om.setPhone(outlet.getPhone());
		om.setDiscount(outlet.getDiscount());
		return om;
	}
}
