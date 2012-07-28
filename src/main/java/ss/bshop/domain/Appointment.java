package ss.bshop.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Outlet outlet;
	
	@ManyToOne
	private SalesRep salesRep;
	
	@Column(nullable = false)
	private Integer weekDay;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public SalesRep getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(SalesRep salesRep) {
		this.salesRep = salesRep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((outlet == null) ? 0 : outlet.hashCode());
		result = prime * result
				+ ((salesRep == null) ? 0 : salesRep.hashCode());
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
		Appointment other = (Appointment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (outlet == null) {
			if (other.outlet != null)
				return false;
		} else if (!outlet.equals(other.outlet))
			return false;
		if (salesRep == null) {
			if (other.salesRep != null)
				return false;
		} else if (!salesRep.equals(other.salesRep))
			return false;
		return true;
	}

	public Integer getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
	}
	
	
}
