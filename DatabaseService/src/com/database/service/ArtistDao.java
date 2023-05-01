package com.database.service;

import java.util.HashMap;
import java.util.Map;

public interface ArtistDao {

	public boolean save(Map<String, String> data);
	public Map<String, String> findById(String artistId);
	
}
