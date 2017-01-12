/**
 * 
 */
package org.bluevox.inc.ch02.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.bluevox.inc.ch02.model.Contact;
/**
 * @author wnorman
 *
 */
public interface ContactDao extends CrudRepository<Contact, Long> {
	List<Contact> findByEmailLike(String email);

}
