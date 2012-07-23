package ss.bshop.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class SalesRep {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
       // @Column(nullable=false)
        @OneToOne
        private User user;
        
        @ManyToOne
        @JoinColumn(name="id")
        private SuperVisor supervisor;
              
	@Column(nullable=false)
        @OneToMany(mappedBy="salesrep")
        private Set<Payment> payments = new HashSet<Payment>();
        
        @Column(nullable=false)
        @OneToMany(mappedBy="salesrep")
        private Set<Visit> visits = new HashSet<Visit>();
        
        @Column(nullable=false)
        @OneToMany(mappedBy="salesrep")
        private Set<Appointment> appointments = new HashSet<Appointment>();
	
        @Column
        private String phone;

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SuperVisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(SuperVisor supervisor) {
        this.supervisor = supervisor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
        
        

}
