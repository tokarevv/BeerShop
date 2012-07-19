package ss.bshop.service;

import java.util.List;
import ss.bshop.domain.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);

	public Contact getContact(Integer contactId);
}
