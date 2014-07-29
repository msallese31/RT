package com.example.randomthought;

import com.example.randomthought.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "thoughtendpoint", namespace = @ApiNamespace(ownerDomain = "example.com", ownerName = "example.com", packagePath = "randomthought"))
public class ThoughtEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listThought")
	public CollectionResponse<Thought> listThought(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Thought> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Thought as Thought");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Thought>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Thought obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Thought> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getThought")
	public Thought getThought(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		Thought thought = null;
		try {
			thought = mgr.find(Thought.class, id);
		} finally {
			mgr.close();
		}
		return thought;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param thought the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertThought")
	public Thought insertThought(Thought thought) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsThought(thought)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(thought);
		} finally {
			mgr.close();
		}
		return thought;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param thought the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateThought")
	public Thought updateThought(Thought thought) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsThought(thought)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(thought);
		} finally {
			mgr.close();
		}
		return thought;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeThought")
	public void removeThought(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		try {
			Thought thought = mgr.find(Thought.class, id);
			mgr.remove(thought);
		} finally {
			mgr.close();
		}
	}

	private boolean containsThought(Thought thought) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Thought item = mgr.find(Thought.class, thought.getId());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
