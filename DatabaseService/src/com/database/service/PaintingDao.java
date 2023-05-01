package com.database.service;

import java.util.Map;

public interface PaintingDao {

	public boolean save(Map<String, String> data);
	public Map<String, String> findById(String paintingId);
	
}
