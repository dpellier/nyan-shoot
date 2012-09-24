package com.sfeir.server.dao;

import java.util.List;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.util.DAOBase;

public class GenericDao<T> extends DAOBase {
	private Class<T> clazz;

	/**
	 * We've got to get the associated domain class somehow
	 *
	 * @param clazz
	 */
	protected GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Key<T> add(T entity) {
		Key<T> key = ofy().put(entity);
		return key;
	}

	public void delete(T entity) {
		ofy().delete(entity);
	}

	public void delete(Key<T> entityKey) {
		ofy().delete(entityKey);
	}

	public T get(Long id) throws EntityNotFoundException {
		T obj = ofy().get(this.clazz, id);
		return obj;
	}
	
	public List<T> getAll(String orderField) throws EntityNotFoundException {
		List<T> obj = ofy().query(this.clazz).order(orderField).list();
		return obj;
	}
	
	public List<T> getAllById(String orderField, String filterField, String id) throws EntityNotFoundException {
		List<T> res = ofy().query(this.clazz).filter(filterField, id).order(orderField).list();
		return res;
	}
}
