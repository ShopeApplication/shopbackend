package com.nr.shop.service;

import net.sf.json.JSONObject;

public interface MasterService {

	JSONObject findAll() throws Exception;

	JSONObject findCatagories() throws Exception;
	
	JSONObject adminHeader() throws Exception;


}
