/**
 * 
 */
package org.bluevox.inc.ch02.dao.jpa;

import static org.springframework.util.Assert.notNull;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bluevox.inc.ch02.dao.ContactDao;
import org.bluevox.inc.ch02.model.Contact;
import org.springframework.stereotype.Repository;

/**
 * @author wnorman
 *
 */
@Repository
public class JpaContactDao implements ContactDao {
	
	//EM is shared and thread safe. This would be equivalent to 
	//Hibernate's SessionFactory mechanism; i.e. injecting a Hibernate Session.
	@PersistenceContext private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see org.bluevox.inc.ch02.dao.ContactDao#findByEmail(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findByEmail(String email) {
		notNull(email, "email can't be null");
		return entityManager
				.createNamedQuery("findContactsByEmail")
				.setParameter("email", "%" + email + "%")
				.getResultList();
	}

	@Override
	public long count() {
		return (Long)entityManager
			.createQuery("select count(*) from Contact")
			.getSingleResult();
	}

	@Override
	public void create(Contact contact) {
		entityManager.persist(contact);
	}

	@Override
	public void delete(Contact contact) {
		notNull(contact, "contact can't be null");
		entityManager.remove(contact);
	}

	@Override
	public void deleteAll() {
		entityManager
			.createQuery("delete from Contact")
			.executeUpdate();
	}

	@Override
	public void deleteById(Serializable id) {
		notNull(id, "id can't be null");
		entityManager
			.createQuery("delete from Contact where id = :id")
			.setParameter("id", id)
			.executeUpdate();
	}

	@Override
	public boolean exists(Serializable id) {
		notNull(id, "id can't be null");
		return (get(id) != null);
	}

	@Override
	public Contact get(Serializable id) {
		return entityManager.find(Contact.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAll() {
		return (List<Contact>)entityManager
			.createQuery("from Contact")
			.getResultList();
	}

	@Override
	public Contact load(Serializable id) {
		notNull(id, "id can't be null");
		
		// TODO check whether there's a JPA equivalent to Hibernate load()
		Contact contact = get(id);
		if (contact == null) {
			throw new RuntimeException("no such contact: " + id);
		}
		return contact;
	}

	@Override
	public void update(Contact contact) {
		notNull(contact, "contact can't be null");
		entityManager.merge(contact);
	}

}
