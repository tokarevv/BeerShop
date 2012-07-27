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

import ss.bshop.domain.Manager;
import ss.bshop.domain.User;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ManagerDAOTest {

	@Autowired
	private IManagerDAO managerDao;
	@Test
	public void testSaveAndLoad() {
		Manager manager = createManager("TestLogin");
		managerDao.addManager(manager);
		Manager read = managerDao.getManager(manager.getId());
		Assert.assertEquals(manager, read);
	}

	@Test
	public void testUpdateAndLoad() {
		Manager manager = createManager("TestLogin");
		managerDao.addManager(manager);
		/*====================================================================*/
		User user = new User();
		user.setLogin("newLogin");
		/*====================================================================*/
		manager.setUser(user);
		managerDao.updateManager(manager);
		Manager read = managerDao.getManager(manager.getId());
		Assert.assertEquals(manager, read);
	}

	@Test
	public void testSaveAndGetAll() {
		List<Manager> expected = new ArrayList<Manager>();
		Manager manager = createManager("TestLogin");
		managerDao.addManager(manager);
		expected.add(manager);
		manager = createManager("TestLogin");
		managerDao.addManager(manager);
		expected.add(manager);
		List<Manager> actual = managerDao.getAllManagers();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSaveAndDelete() {
		Manager manager = createManager("TestLogin");
		managerDao.addManager(manager);
		managerDao.removeManager(manager.getId());
		List<Manager> managerlist = managerDao.getAllManagers();
		Assert.assertTrue(managerlist.isEmpty());
	}

	private Manager createManager(String login) {
		Manager manager = new Manager();
		User user = new User();
		user.setLogin(login);
		manager.setUser(user);
		return manager;
	}
}
