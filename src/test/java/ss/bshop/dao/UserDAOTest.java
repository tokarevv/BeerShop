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

import ss.bshop.domain.User;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDAOTest {

	@Autowired
	private IUserDAO userDao;
        
	@Test
	public void testSaveAndLoad() {
		User user = createUser("TestLogin");
		userDao.addUser(user);
		User read = userDao.getUser(user.getId());
		Assert.assertEquals(user, read);
	}

	@Test
	public void testUpdateAndLoad() {
		User user = createUser("TestLogin");
		userDao.addUser(user);
		user.setFullname("Senior Junior");
		userDao.updateUser(user);
		User read = userDao.getUser(user.getId());
		Assert.assertEquals(user, read);
	}

	@Test
	public void testSaveAndGetAll() {
		List<User> expected = new ArrayList<User>();
		User user = createUser("TestLogin");
		userDao.addUser(user);
		expected.add(user);
		user = createUser("TestLogin");
		userDao.addUser(user);
		expected.add(user);
		List<User> actual = userDao.getAllUsers();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSaveAndDelete() {
		User user = createUser("TestLogin");
		userDao.addUser(user);
		userDao.removeUser(user.getId());
		List<User> userlist = userDao.getAllUsers();
		Assert.assertTrue(userlist.isEmpty());
	}

	private User createUser(String login) {
		User user = new User();
		user.setLogin(login);
		return user;
	}
}
