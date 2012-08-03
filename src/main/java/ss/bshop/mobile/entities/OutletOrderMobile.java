package ss.bshop.mobile.entities;

import java.util.List;

public class OutletOrderMobile {

	private String type;
	private byte discount;
	private double payment;
	private List<OutletOrderStructureMobile> structure;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte getDiscount() {
		return discount;
	}
	public void setDiscount(byte discount) {
		this.discount = discount;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public List<OutletOrderStructureMobile> getStructure() {
		return structure;
	}
	public void setStructure(List<OutletOrderStructureMobile> structure) {
		this.structure = structure;
	}
}
