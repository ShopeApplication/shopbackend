package com.nr.shop.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface MasterService {

	JSONObject findAll() throws Exception;

	JSONObject findCatagories() throws Exception;
	
	JSONObject adminHeader(String role) throws Exception;

	JSONArray findCatagories(String type) throws Exception;


}
