package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.ContactSample;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(ContactSample contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	@SuppressWarnings("unchecked")
	public List<ContactSample> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contact")
			.list();
	}

	public void removeContact(Integer id) {
		ContactSample contact = (ContactSample) sessionFactory.getCurrentSession().load(
				ContactSample.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}

	@Override
	public ContactSample getContact(Integer contactId) {
		
		return (ContactSample) sessionFactory.getCurrentSession().get(ContactSample.class, contactId);
	}
}
