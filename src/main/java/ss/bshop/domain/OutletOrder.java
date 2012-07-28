package ss.bshop.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


	
	
	
	

@Entity
public class OutletOrder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String type; 
	
	@Column
	private byte discount; 
	
	@Column
	private double payment;
	
	@OneToOne
	private Visit visit; 
	
	@Column
	@OneToMany
	private List<OutletOrderStructure> structure; 

	
	//getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public List<OutletOrderStructure> getStructure() {
		return structure;
	}

	public void setStructure(List<OutletOrderStructure> structure) {
		this.structure = structure;
	}

	@Override
        public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + discount;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(payment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((structure == null) ? 0 : structure.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		//result = prime * result + ((visit == null) ? 0 : visit.hashCode());
		return result;
	}

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final OutletOrder other = (OutletOrder) obj;
            if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
                return false;
            }
            if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
                return false;
            }
            if (this.discount != other.discount) {
                return false;
            }
            if (Double.doubleToLongBits(this.payment) != Double.doubleToLongBits(other.payment)) {
                return false;
            }
            if (this.structure != other.structure && (this.structure == null || !this.structure.equals(other.structure))) {
                return false;
            }
            return true;
        }
        
		
}
