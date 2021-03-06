package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import models.Location;

@Repository
public class LocationDAO {

	
	@PersistenceContext
	private EntityManager em;
	
	public List<Location> selectLocation(String locationCode) {
		System.out.println(locationCode);
		String sql = "SELECT * FROM location where json_CONTAINS(location_json, '{\"location_code\" : \""+locationCode+"\"}')";
		System.out.println(sql);
		List<Location> locationList = (List<Location>) this.em.createNativeQuery(sql, Location.class).getResultList();
		return locationList;
	}

}
