/**
 * 
 */
package org.bluevox.inc.ch02.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bluevox.inc.ch02.model.Contact;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * @author wnorman
 *
 */
@Component
public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getLong(1));
		contact.setLastName(rs.getString(2));
		contact.setFirstName(rs.getString(3));
		contact.setMiddleInitial(rs.getString(4));
		contact.setEmail(rs.getString(5));
		return contact;
	}

}
