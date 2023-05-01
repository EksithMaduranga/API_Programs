package com.database.service;

import java.util.Map;

public interface DeliveryDao {

	public boolean save(Map<String, String> data);
	public Map<String, String> findById(String deliveryId);
	
}
