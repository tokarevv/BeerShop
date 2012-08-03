package ss.bshop.mobile.entities;

import java.util.Date;

public class VisitMobile {

	private Date time;
	private double lat;
	private double lng;
	private OutletMobile outlet;
	private OutletOrderMobile outletOrder;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public OutletMobile getOutlet() {
		return outlet;
	}
	public void setOutlet(OutletMobile outlet) {
		this.outlet = outlet;
	}
	public OutletOrderMobile getOutletOrder() {
		return outletOrder;
	}
	public void setOutletOrder(OutletOrderMobile outletOrder) {
		this.outletOrder = outletOrder;
	}
}
