package ss.bshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class SuperVisor implements Serializable {
	
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @OneToOne(optional=false, cascade=CascadeType.ALL)
        private User user;
                
	@OneToMany(mappedBy="supervisor")
        private Set<SalesRep> salesrep = new HashSet<SalesRep>();
	
    @Column
        private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SalesRep> getSalesrep() {
        return salesrep;
    }

    public void setSalesrep(Set<SalesRep> salesrep) {
        this.salesrep = salesrep;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
