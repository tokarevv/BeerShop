package ss.bshop.dao;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IPaymentDAO;
import ss.bshop.domain.Payment;

/**
 * PaymentDAO Tester. 
 */
@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PaymentDAOTest {

    @Autowired
    private IPaymentDAO daoI;

    @Test
	public void testSave() throws Exception {
		Payment payment = new Payment();
		payment.setAmount(23);
		//payment.setOutlet(new Outlet());
		//payment.setTime(time);
		
		daoI.add(payment);
		List<Payment> payList = daoI.getAll();

		// for(Payment a : payList){
		// System.out.println(a);
		// }

		Assert.assertEquals(payment, payList.get(payList.size() - 1));
		Assert.assertEquals(payment.getAmount(),
				payList.get(payList.size() - 1).getAmount());
	}
    
    /**
     * Method: get(Integer Id)
     */
    @Test
	public void testGet() throws Exception {

    	Payment payment = new Payment();
    	payment.setAmount(23);

		daoI.add(payment);
		List<Payment> payList = daoI.getAll();

		Payment loadedPayment = payList.get(payList.size() - 1);
		Long loadedPaymentId = loadedPayment.getId();
		Assert.assertEquals(loadedPayment, daoI.get(loadedPaymentId));
	}
    

}  
