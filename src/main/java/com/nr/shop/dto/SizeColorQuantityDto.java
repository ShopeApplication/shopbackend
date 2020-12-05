package com.nr.shop.dto;

import java.io.Serializable;

public class SizeColorQuantityDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int size;
	
	private String color;
	
	private int quantity;

	public SizeColorQuantityDto(int id, int size, String color, int quantity) {
		super();
		this.id = id;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
	}

	public SizeColorQuantityDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
