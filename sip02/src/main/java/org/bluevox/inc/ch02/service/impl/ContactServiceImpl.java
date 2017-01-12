/**
 * 
 */
package org.bluevox.inc.ch02.service.impl;

import static org.springframework.util.Assert.notNull;

import java.util.ArrayList;
import java.util.Iterator;
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
		notNull(contact, "contact can't be null");
		contactDao.save(contact);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContacts()
	 */
	@Override
	public List<Contact> getContacts() {
		Iterable<Contact> iterable = contactDao.findAll();
		Iterator<Contact> iterator = iterable.iterator();
		List<Contact> contacts = new ArrayList<Contact>();
		while (iterator.hasNext()) {
			contacts.add(iterator.next());
		}
		return contacts;
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContactsByEmail(java.lang.String)
	 */
	@Override
	public List<Contact> getContactsByEmail(String email) {
		notNull(email, "email can't be null");
		return contactDao.findByEmailLike("%" + email + "%");
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContact(java.lang.Long)
	 */
	@Override
	public Contact getContact(Long id) {
		notNull(id, "id can't be null");
		return contactDao.findOne(id);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#updateContact(org.bluevox.inc.ch02.model.Contact)
	 */
	@Override
	public void updateContact(Contact contact) {
		notNull(contact, "contact can't be null");
		contactDao.save(contact);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#deleteContact(java.lang.Long)
	 */
	@Override
	public void deleteContact(Long id) {
		notNull(id, "id can't be null");
		contactDao.delete(id);
	}
	
}
