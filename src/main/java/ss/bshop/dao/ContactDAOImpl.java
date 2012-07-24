package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	@SuppressWarnings("unchecked")
	public List<Contact> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contact")
			.list();
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}

	@Override
	public Contact getContact(Integer contactId) {
		
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, contactId);
	}
}
