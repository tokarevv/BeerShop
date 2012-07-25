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

import ss.bshop.domain.SuperVisor;
import ss.bshop.domain.User;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SuperVisorDAOTest {

	@Autowired
	private ISuperVisorDAO superVisorDao;
	@Test
	public void testSaveAndLoad() {
		SuperVisor superVisor = createSuperVisor("TestLogin");
		superVisorDao.addSuperVisor(superVisor);
		SuperVisor read = superVisorDao.getSuperVisor(superVisor.getId());
		Assert.assertEquals(superVisor, read);
	}

	@Test
	public void testUpdateAndLoad() {
		SuperVisor superVisor = createSuperVisor("TestLogin");
		superVisorDao.addSuperVisor(superVisor);
		/*====================================================================*/
		User user = new User();
		user.setLogin("newLogin");
		/*====================================================================*/
		superVisor.setUser(user);
		superVisorDao.updateSuperVisor(superVisor);
		SuperVisor read = superVisorDao.getSuperVisor(superVisor.getId());
		Assert.assertEquals(superVisor, read);
	}

	@Test
	public void testSaveAndGetAll() {
		List<SuperVisor> expected = new ArrayList<SuperVisor>();
		SuperVisor superVisor = createSuperVisor("TestLogin");
		superVisorDao.addSuperVisor(superVisor);
		expected.add(superVisor);
		superVisor = createSuperVisor("TestLogin");
		superVisorDao.addSuperVisor(superVisor);
		expected.add(superVisor);
		List<SuperVisor> actual = superVisorDao.getAllSuperVisors();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSaveAndDelete() {
		SuperVisor superVisor = createSuperVisor("TestLogin");
		superVisorDao.addSuperVisor(superVisor);
		superVisorDao.removeSuperVisor(superVisor.getId());
		List<SuperVisor> superVisorlist = superVisorDao.getAllSuperVisors();
		Assert.assertTrue(superVisorlist.isEmpty());
	}

	private SuperVisor createSuperVisor(String login) {
		SuperVisor superVisor = new SuperVisor();
		User user = new User();
		user.setLogin(login);
		superVisor.setUser(user);
		return superVisor;
	}
}
