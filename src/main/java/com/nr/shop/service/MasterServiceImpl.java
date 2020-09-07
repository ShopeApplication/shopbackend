package com.nr.shop.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;


@Service
public class MasterServiceImpl implements MasterService {

	private String getJSONdataStringFormate() throws IOException {
		String jsondata = "";
		FileInputStream inputStream = null;
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			File configFile = new File(classLoader.getResource("shop_master").getFile());

			inputStream = new FileInputStream(configFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				jsondata = jsondata.concat(line);
			}

			reader.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			inputStream.close();
		}
		return jsondata;
	}

	@Override
	public JSONObject findAll() throws IOException {
		String jsondata = getJSONdataStringFormate();
		JSONObject json = JSONObject.fromObject(jsondata);
		return json;
	}

	@Override
	public JSONObject findCatagories() throws Exception {
		String jsondata = getJSONdataStringFormate();
		JSONObject json = JSONObject.fromObject(jsondata);
		return json.getJSONObject("master").getJSONObject("catagories");
	}
	
	@Override
	public JSONObject adminHeader() throws Exception {
		String jsondata = getJSONdataStringFormate();
		JSONObject json = JSONObject.fromObject(jsondata);
		return json.getJSONObject("admin");
	}

}