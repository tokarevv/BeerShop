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

import ss.bshop.domain.SalesRep;
import ss.bshop.domain.User;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SalesRepDAOTest {

	@Autowired
	private ISalesRepDAO salesRepDao;
	@Test
	public void testSaveAndLoad() {
		SalesRep salesRep = createSalesRep("TestLogin");
		salesRepDao.addSalesRep(salesRep);
		SalesRep read = salesRepDao.getSalesRep(salesRep.getId());
		Assert.assertEquals(salesRep, read);
	}

	@Test
	public void testUpdateAndLoad() {
		SalesRep salesRep = createSalesRep("TestLogin");
		salesRepDao.addSalesRep(salesRep);
		/*====================================================================*/
		User user = new User();
		user.setLogin("newLogin");
		/*====================================================================*/
		salesRep.setUser(user);
		salesRepDao.updateSalesRep(salesRep);
		SalesRep read = salesRepDao.getSalesRep(salesRep.getId());
		Assert.assertEquals(salesRep, read);
	}

	@Test
	public void testSaveAndGetAll() {
		List<SalesRep> expected = new ArrayList<SalesRep>();
		SalesRep salesRep = createSalesRep("TestLogin");
		salesRepDao.addSalesRep(salesRep);
		expected.add(salesRep);
		salesRep = createSalesRep("TestLogin");
		salesRepDao.addSalesRep(salesRep);
		expected.add(salesRep);
		List<SalesRep> actual = salesRepDao.getAllSalesReps();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSaveAndDelete() {
		SalesRep salesRep = createSalesRep("TestLogin");
		salesRepDao.addSalesRep(salesRep);
		salesRepDao.removeSalesRep(salesRep.getId());
		List<SalesRep> salesReplist = salesRepDao.getAllSalesReps();
		Assert.assertTrue(salesReplist.isEmpty());
	}

	private SalesRep createSalesRep(String login) {
		SalesRep salesRep = new SalesRep();
		User user = new User();
		user.setLogin(login);
		salesRep.setUser(user);
		return salesRep;
	}
}
