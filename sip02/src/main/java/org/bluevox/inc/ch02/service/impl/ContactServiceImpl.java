/**
 * 
 */
package org.bluevox.inc.ch02.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.bluevox.inc.ch02.dao.ContactDao;
import org.bluevox.inc.ch02.model.Contact;
import org.bluevox.inc.ch02.service.ContactService;

/**
 * @author wnorman
 *
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Inject private ContactDao contactDao;
	
	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#createContact(org.bluevox.inc.ch02.model.Contact)
	 */
	@Override
	public void createContact(Contact contact) {
		contactDao.create(contact);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContacts()
	 */
	@Override
	public List<Contact> getContacts() {
		return contactDao.getAll();
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContactsByEmail(java.lang.String)
	 */
	@Override
	public List<Contact> getContactsByEmail(String email) {
		return contactDao.findByEmail(email);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContact(java.lang.Long)
	 */
	@Override
	public Contact getContact(Long id) {
		return contactDao.get(id);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#updateContact(org.bluevox.inc.ch02.model.Contact)
	 */
	@Override
	public void updateContact(Contact contact) {
		contactDao.update(contact);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#deleteContact(java.lang.Long)
	 */
	@Override
	public void deleteContact(Long id) {
		contactDao.deleteById(id);;
	}
	
}
