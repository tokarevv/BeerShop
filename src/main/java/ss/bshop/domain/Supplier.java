package ss.bshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Supplier implements Serializable {
	
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        
        @Column(nullable=false)
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
        
	@OneToMany(mappedBy="supplier")
        @OrderBy("name")
        private Set<Article> goods = new HashSet<Article>();
	
        @Column
        private String comment;

        public Supplier() {
        }

        //constructors

        public Supplier(String name) {
            this.name = name;
        }
        
	
	//getters and setters
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

	public Set<Article> getGoods() {
		return goods;
	}

	public void setGoods(Set<Article> goods) {
		this.goods = goods;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	//equals and hash
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((INN == null) ? 0 : INN.hashCode());
		result = prime * result + ((OKPO == null) ? 0 : OKPO.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Supplier other = (Supplier) obj;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (id != other.id)
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
		if (svidNumber == null) {
			if (other.svidNumber != null)
				return false;
		} else if (!svidNumber.equals(other.svidNumber))
			return false;
		return true;
	}


}
