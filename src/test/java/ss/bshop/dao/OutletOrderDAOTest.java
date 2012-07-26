/**
 * @author Kostya Tarasov
 */

package ss.bshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.domain.OutletOrder;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OutletOrderDAOTest {

	@Autowired
	private IOutletOrder outletOrderDAO;

	@Test
	public void testSaveAndRead() {
		OutletOrder order = new OutletOrder();
		outletOrderDAO.add(order);
		OutletOrder read = outletOrderDAO.get(order.getId());
		Assert.assertEquals(order, read);
	}

	@Test
	public void testUpdateAndRead() {
		OutletOrder order = new OutletOrder();
		outletOrderDAO.add(order);
		order.setPayment(123.45);
		outletOrderDAO.update(order);
		OutletOrder read = outletOrderDAO.get(order.getId());
		Assert.assertEquals(order, read);
	}

	@Test
	public void testSaveAndGetAll() {
		List<OutletOrder> orderList = new ArrayList<OutletOrder>();
		OutletOrder order = new OutletOrder();
		outletOrderDAO.add(order);
		orderList.add(order);
		order = new OutletOrder();
		outletOrderDAO.add(order);
		orderList.add(order);
		List<OutletOrder> read = outletOrderDAO.getAll();
		Assert.assertEquals(orderList, read);
	}

	@Test
	public void testSaveAndDelete() {
		OutletOrder order = new OutletOrder();
		outletOrderDAO.add(order);
		outletOrderDAO.remove(order.getId());
		List<OutletOrder> orderList = outletOrderDAO.getAll();
		Assert.assertTrue(orderList.isEmpty());
	}
}
