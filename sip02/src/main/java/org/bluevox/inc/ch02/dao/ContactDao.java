/**
 * 
 */
package org.bluevox.inc.ch02.dao;

import org.bluevox.inc.ch02.model.Contact;
import org.bluevox.inc.dao.Dao;
import java.util.List;

/**
 * @author wnorman
 *
 */
public interface ContactDao extends Dao<Contact> {
	List<Contact> findByEmail(String email);
}
