package com.database.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArtistDaoImpl implements ArtistDao{

	private static Map<String, Map<String, String>> dataList = new HashMap<>();

	@Override
	public boolean save(Map<String, String> data) {
		
		String artistID = data.get("artistId");
		
		try {
			
			dataList.put(artistID, new HashMap<String, String>(data));
			return true;
			
		} catch (Exception e) {
			
			System.err.println(e);
			
		}
		
		return false;
		
	}

	@Override
	public Map<String, String> findById(String artistID) {
		
		Map<String, String> data = new HashMap<>();
		
		try {
			
			data = dataList.get(artistID);
			if(Objects.isNull(data)){
				
				return null;
				
			}
			
		} catch (Exception e) {
			
			System.err.println(e);
			
		}
		
		return data;
		
	}

}
