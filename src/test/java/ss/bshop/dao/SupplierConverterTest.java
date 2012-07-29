package ss.bshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ss.bshop.dao.IAppointmentDAO;
import ss.bshop.domain.Appointment;
import ss.bshop.domain.Supplier;
import ss.bshop.faces.converters.SupplierConverter;


@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SupplierConverterTest {
    @Autowired
    private ISupplierDAO daoI;

    @Autowired
    private SupplierConverter sc;
//    
//	<!-- Менеджер транзакций -->
//	<bean id="SupplierConverter"
//		class="ss.bshop.faces.converters.SupplierConverter">
//		<property name="supplierService" ref="supplierService" />
//	</bean>	
	
  

    @Test
	public void testSave() throws Exception {
       	Supplier suppl = new Supplier();
    	suppl.setAddress("adress");
		suppl.setName("name");
		
		daoI.add(suppl);
		List<Supplier> supplList = daoI.getAll();

		Supplier loadedVisit = supplList.get(supplList.size() - 1);
		Long loadedId = loadedVisit.getId();
		System.out.println(daoI.get(loadedId));
		
		//SupplierConverter sc = new SupplierConverter();
    	
    	//System.out.println(sc.getAsObject(null, null, loadedId.toString()));
    	//System.out.println(sc.getAsString(facesContext, component, value));
    	assertEquals(loadedVisit, sc.getAsObject(null, null, loadedId.toString()));
    	
	}
 
}  