/**
 * 
 */
package org.bluevox.inc.ch02.dao.hbn;

import java.util.List;
import org.bluevox.inc.ch02.dao.ContactDao;
import org.bluevox.inc.ch02.model.Contact;
import org.bluevox.inc.dao.hibernate.AbstractHbnDao;
import org.springframework.stereotype.Repository;

/**
 * @author wnorman
 *
 */
@Repository
public class HbnContactDao extends AbstractHbnDao<Contact> implements ContactDao {

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.dao.ContactDao#findByEmail(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findByEmail(String email) {
		return getSession()
				.getNamedQuery("findContactsByEmail")
				.setString("email", "%" + email + "%")
				.list();
	}

}
