package ss.bshop.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Manager {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;
        
        @Column
	@Temporal( value = TemporalType.TIMESTAMP ) 
        private Date dateOfDirect;
        
        
}
