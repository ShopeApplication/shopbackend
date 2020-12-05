package com.nr.shop.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int createdby;
	
	private Date createdtime;
	
	private int updatedby;
	
	private Date updatedtime;
	
	private String brand;
	
	private double price;
	
	private double offerprice;
	
	private String catagoryType;//Male,Female,Kid etc
	
	private String catagory;
	
	private String description;
	
	private String review;
	
	private String image;
	
	private int status;
	
	private List<SizeColorQuantityDto> sizecolorquantity=new ArrayList<SizeColorQuantityDto>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public int getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdatedtime() {
		return updatedtime;
	}

	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOfferprice() {
		return offerprice;
	}

	public void setOfferprice(double offerprice) {
		this.offerprice = offerprice;
	}

	public String getCatagoryType() {
		return catagoryType;
	}

	public void setCatagoryType(String catagoryType) {
		this.catagoryType = catagoryType;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<SizeColorQuantityDto> getSizecolorquantity() {
		return sizecolorquantity;
	}

	public void setSizecolorquantity(List<SizeColorQuantityDto> sizecolorquantity) {
		this.sizecolorquantity = sizecolorquantity;
	}

	
}
