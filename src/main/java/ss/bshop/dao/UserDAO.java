/**
 * @author Kostya Tarasov
 */
package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ss.bshop.domain.User;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void removeUser(Long id) {
		User toDelete = (User) sessionFactory.getCurrentSession().
				get(User.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
	}

	@Override
	public User getUser(Long id) {
		User toReturn = (User) sessionFactory.getCurrentSession().
				get(User.class, id);
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		List<User> users = sessionFactory.getCurrentSession().
				createQuery("from User").list();
		return users;
	}
}
