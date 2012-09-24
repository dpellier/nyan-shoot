package com.sfeir.server.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Version;

@Entity
public class Town {
	
	/** Methode obligatoire pour RF. */
	public Town() {};

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@Version
	@Column(name="version")
	private Integer version;

	private String name;
	private String departId;
	
	
	/** Methode obligatoire pour RF. */
	public String getId() { return id; }
	/** Methode obligatoire pour RF. */
	public Integer getVersion() { return version; }
	public void setVersion(Integer version) { this.version = version; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDepartId() { return departId; }
	public void setDepartId(String departId) { this.departId = departId; }

	
	
	public static final EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}
	
	/** Methode obligatoire pour RF. */
	public static Town findTown(Integer id) {
		if (id == null) {
			return null;
		}
		EntityManager em = getEntityManager();
		try {
			Town town = em.find(Town.class, id);
			return town;
		} finally {
			em.close();
		}
	}

	/**
	 * @return Toutes les villes
	 */
	@SuppressWarnings("unchecked")
	public static List<Town> findAllVilles() {
		EntityManager em = getEntityManager();
		try {
			List<Town> villes = em.createQuery("select t from Town t")
					.getResultList();
			// force la recuperation de toutes les villes.
			villes.size();
			return villes;
		} finally {
			em.close();
		}
	}

	/**
	 * @param firstResult
	 * @param maxResult
	 * @return - pour la pagination, retourne toutes les villes commencant a firstResult et se limitant a maxResult.
	 */
	@SuppressWarnings("unchecked")
	public static List<Town> findVilles(int firstResult, int maxResult) {
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("select t from Town t");
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
			List<Town> villes = query.getResultList();
			return villes;
		} finally {
			em.close();
		}
	}

}
