package ss.bshop.mobile.entities;

import ss.bshop.domain.Outlet;

public class OutletMobile {

	private Long id;
	private String name;
	private String address;
	private String phone;
	private byte discount;
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
	public byte getDiscount() {
		return discount;
	}
	public void setDiscount(byte discount) {
		this.discount = discount;
	}
	public static OutletMobile fromOutlet(Outlet outlet) {
		OutletMobile om = new OutletMobile();
		om.id = outlet.getId();
		om.name = outlet.getName();
		om.address = outlet.getAddress();
		om.phone = outlet.getPhone();
		om.discount = outlet.getDiscount();
		return om;
	}
}
