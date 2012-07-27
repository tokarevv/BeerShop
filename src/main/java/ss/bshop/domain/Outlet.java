package ss.bshop.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Outlet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String address;

	@Column
	private String phone;

	@Column
	private String email;

	@Column
	private String OKPO;

	@Column
	private String INN;

	@Column
	private String svidNumber;

    @Column
    private String comment;

	@Column
	private String sertificateNumber;
	
	@Column
	private String contractNumber;

	@Column
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date registerDate;

	@OneToOne
	private SalesRep salesRep;
	
	@Column
	private String groupp;
	
	@Column
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOKPO() {
		return OKPO;
	}

	public void setOKPO(String oKPO) {
		OKPO = oKPO;
	}

	public String getINN() {
		return INN;
	}

	public void setINN(String iNN) {
		INN = iNN;
	}

	public String getSvidNumber() {
		return svidNumber;
	}

	public void setSvidNumber(String svidNumber) {
		this.svidNumber = svidNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSertificateNumber() {
		return sertificateNumber;
	}

	public void setSertificateNumber(String sertificateNumber) {
		this.sertificateNumber = sertificateNumber;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public SalesRep getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(SalesRep salesRep) {
		this.salesRep = salesRep;
	}

	public String getGroup() {
		return groupp;
	}

	public void setGroup(String group) {
		this.groupp = group;
	}

	public byte getDiscount() {
		return discount;
	}

	public void setDiscount(byte discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((INN == null) ? 0 : INN.hashCode());
		result = prime * result + ((OKPO == null) ? 0 : OKPO.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((contractNumber == null) ? 0 : contractNumber.hashCode());
		result = prime * result + discount;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((groupp == null) ? 0 : groupp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result
				+ ((salesRep == null) ? 0 : salesRep.hashCode());
		result = prime
				* result
				+ ((sertificateNumber == null) ? 0 : sertificateNumber
						.hashCode());
		result = prime * result
				+ ((svidNumber == null) ? 0 : svidNumber.hashCode());
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
		Outlet other = (Outlet) obj;
		if (INN == null) {
			if (other.INN != null)
				return false;
		} else if (!INN.equals(other.INN))
			return false;
		if (OKPO == null) {
			if (other.OKPO != null)
				return false;
		} else if (!OKPO.equals(other.OKPO))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (contractNumber == null) {
			if (other.contractNumber != null)
				return false;
		} else if (!contractNumber.equals(other.contractNumber))
			return false;
		if (discount != other.discount)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (groupp == null) {
			if (other.groupp != null)
				return false;
		} else if (!groupp.equals(other.groupp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (registerDate == null) {
			if (other.registerDate != null)
				return false;
		} else if (!registerDate.equals(other.registerDate))
			return false;
		if (salesRep == null) {
			if (other.salesRep != null)
				return false;
		} else if (!salesRep.equals(other.salesRep))
			return false;
		if (sertificateNumber == null) {
			if (other.sertificateNumber != null)
				return false;
		} else if (!sertificateNumber.equals(other.sertificateNumber))
			return false;
		if (svidNumber == null) {
			if (other.svidNumber != null)
				return false;
		} else if (!svidNumber.equals(other.svidNumber))
			return false;
		return true;
	}
	
	
	
}
