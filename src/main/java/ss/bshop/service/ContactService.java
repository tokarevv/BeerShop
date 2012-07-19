package ss.bshop.service;

import java.util.List;
import ss.bshop.domain.ContactSample;

public interface ContactService {

	public void addContact(ContactSample contact);

	public List<ContactSample> listContact();

	public void removeContact(Integer id);

	public ContactSample getContact(Integer contactId);
}
