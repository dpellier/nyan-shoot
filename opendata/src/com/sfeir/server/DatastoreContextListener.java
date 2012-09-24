package com.sfeir.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sfeir.server.dao.DepartDao;
import com.sfeir.server.dao.RegionDao;
import com.sfeir.server.dao.VilleDao;
import com.sfeir.shared.Depart;
import com.sfeir.shared.Region;
import com.sfeir.shared.Ville;

/**
 * Initialisation du data store au demarrage du contexte.
 * 
 * @author sfeir
 * 
 */
public class DatastoreContextListener implements ServletContextListener {

	private VilleDao villeDao = new VilleDao();
	private DepartDao departDao = new DepartDao();
	private RegionDao regionDao = new RegionDao();

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if (regionDao.ofy().query(Region.class).count() == 0) {
			parseFichierRegion();
		}
		if (departDao.ofy().query(Depart.class).count() == 0) {
			parseFichierDepart();
		}
		if (villeDao.ofy().query(Ville.class).count() == 0) {
			parseFichierVille();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void parseFichierVille() {

		BufferedReader reader = null;
		String ligne = null;
		try {
			reader = new BufferedReader(new InputStreamReader(this.getClass()
					.getResourceAsStream("liste_ville.txt"), "UTF-8"));
			while ((ligne = reader.readLine()) != null) {
				String[] data = ligne.split(";");
				villeDao.add(new Ville(data[2] + data[3] + data[4], data[11],
						data[3]));
			}
		} catch (Exception e) {
			throw new RuntimeException(
					"impossible de parser la ligne:" + ligne, e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

	public void parseFichierRegion() {
		BufferedReader reader = null;
		try {
			String ligne;
			reader = new BufferedReader(new InputStreamReader(this.getClass()
					.getResourceAsStream("liste_region.txt"), "UTF-8"));
			while ((ligne = reader.readLine()) != null) {
				String[] data = ligne.split("\\t+", -1);
				regionDao.add(new Region(data[0], data[4]));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

	public void parseFichierDepart() {
		BufferedReader reader = null;
		try {
			String ligne;
			reader = new BufferedReader(new InputStreamReader(this.getClass()
					.getResourceAsStream("liste_depart.txt"), "UTF-8"));
			while ((ligne = reader.readLine()) != null) {
				String[] data = ligne.split("\\t+");
				departDao.add(new Depart(data[1], data[5], data[0]));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

}
