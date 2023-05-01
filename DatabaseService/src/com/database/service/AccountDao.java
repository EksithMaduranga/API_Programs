package com.database.service;

import java.util.Map;

public interface AccountDao {
	
	public boolean save(Map<String, String> data);
	public Map<String, String> findById(String customerId);

}
