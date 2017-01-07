package org.bluevox.inc.ch02.service;

import java.util.List;
import org.bluevox.inc.ch02.model.Contact;




/**
 * @author wnorman
 *
 */
public interface ContactService {
	
	/**
	 * 
	 * Creates the given contact in the persistent store.
	 * 
	 * @param contact
	 * 			contact to create
	 * 
	 * @throws illegalArgumentException
	 * 			if <code>contact</code> is <code>null<\code>
	 * 
	 */
	void createContact(Contact contact);
	
	/**
	 * Returns a list of all contacts. 
	 * Returns an empty list if no contacts are stored.
	 * 
	 * @return list of all contacts.
	 */
	List<Contact> getContacts();
	
	/**
	 * Returns a list of contacts given an associated email.
	 * Returns an empty list if no relation is found.
	 * @param email
	 * 
	 * @return a list of contacts filtered by given email.
	 */
	List<Contact> getContactsByEmail(String email);
	
	/**
	 * Returns a contact given an associated id.
	 * Returns an <code>null</code> if no relation is found.
	 * @param id
	 * 
	 * @return a contact by given id.
	 */
	Contact getContact(Long id);
	
	void updateContact(Contact contact);
	
	/**
	 * Deletes a contact by given id.
	 * 
	 * @param id
	 * 
	 */
	void deleteContact(Long id);
	
	

}
