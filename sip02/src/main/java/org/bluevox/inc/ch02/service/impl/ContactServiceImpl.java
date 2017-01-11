/**
 * 
 */
package org.bluevox.inc.ch02.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.bluevox.inc.ch02.model.Contact;
import org.bluevox.inc.ch02.service.ContactService;

/**
 * @author wnorman
 *
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Inject private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#createContact(org.bluevox.inc.ch02.model.Contact)
	 */
	@Override
	public void createContact(Contact contact) {
		getSession().save(contact);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContacts()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getContacts() {
		return getSession().createQuery("from Contact").list();
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContactsByEmail(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getContactsByEmail(String email) {
		return getSession()
				.getNamedQuery("findContactsByEmail")
				.setString("email", "%" + email + "%")
				.list();
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#getContact(java.lang.Long)
	 */
	@Override
	public Contact getContact(Long id) {
		return (Contact) getSession().get(Contact.class, id);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#updateContact(org.bluevox.inc.ch02.model.Contact)
	 */
	@Override
	public void updateContact(Contact contact) {
		getSession().update(contact);
	}

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.service.ContactService#deleteContact(java.lang.Long)
	 */
	@Override
	public void deleteContact(Long id) {
		getSession().delete(getContact(id));;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
