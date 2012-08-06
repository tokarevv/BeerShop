package ss.bshop.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Visit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column
	@Temporal( value = TemporalType.TIMESTAMP ) 
	private Date time;
	
	@Column
	private  double lat;
	
	@Column
	private double lng;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Outlet outlet;
	
	@OneToOne(cascade = CascadeType.ALL)
	private OutletOrder order;
	
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

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public OutletOrder getOrder() {
		return order;
	}

	public void setOrder(OutletOrder order) {
		this.order = order;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((outlet == null) ? 0 : outlet.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Visit other = (Visit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (outlet == null) {
			if (other.outlet != null)
				return false;
		} else if (!outlet.equals(other.outlet))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	
}
