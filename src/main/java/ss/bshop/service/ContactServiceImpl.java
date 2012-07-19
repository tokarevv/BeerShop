package ss.bshop.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import ss.bshop.dao.ContactDAO;
import ss.bshop.domain.ContactSample;
 
@Service
public class ContactServiceImpl implements ContactService {
 
    @Autowired
    private ContactDAO contactDAO;
 
    @Transactional
    public void addContact(ContactSample contact) {
        contactDAO.addContact(contact);
    }
 
    @Transactional
    public List<ContactSample> listContact() {
 
        return contactDAO.listContact();
    }
 
    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }

	@Override
	public ContactSample getContact(Integer contactId) {
		return contactDAO.getContact(contactId);
	}
}
