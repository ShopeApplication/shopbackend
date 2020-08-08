package com.nr.shop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "male_product")
public class MaleProduct implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int createdby;
	
	@CreationTimestamp
	private Date createdtime;
	
	private int updatedby;
	
	@UpdateTimestamp
	private Date updatedtime;
	
	private String brand;
	
	private double price;
	
	private double offerprice;
	
	private String catagory;
	
	private String description;
	
	private String review;
	
	private String image;
	
	private int status;
	
	@OneToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<SizeColorQuantity> sizecolorquantity=new ArrayList<SizeColorQuantity>();

	public MaleProduct(int id, int createdby, Date createdtime, int updatedby, Date updatedtime, String brand,
			double price, double offerprice, String catagory, String description, String review, String image,
			int status, List<SizeColorQuantity> sizecolorquantity) {
		super();
		this.id = id;
		this.createdby = createdby;
		this.createdtime = createdtime;
		this.updatedby = updatedby;
		this.updatedtime = updatedtime;
		this.brand = brand;
		this.price = price;
		this.offerprice = offerprice;
		this.catagory = catagory;
		this.description = description;
		this.review = review;
		this.image = image;
		this.status = status;
		this.sizecolorquantity = sizecolorquantity;
	}

	public MaleProduct() {
		super();
	}

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

	public List<SizeColorQuantity> getSizecolorquantity() {
		return sizecolorquantity;
	}

	public void setSizecolorquantity(List<SizeColorQuantity> sizecolorquantity) {
		this.sizecolorquantity = sizecolorquantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((catagory == null) ? 0 : catagory.hashCode());
		result = prime * result + createdby;
		result = prime * result + ((createdtime == null) ? 0 : createdtime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		long temp;
		temp = Double.doubleToLongBits(offerprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((sizecolorquantity == null) ? 0 : sizecolorquantity.hashCode());
		result = prime * result + status;
		result = prime * result + updatedby;
		result = prime * result + ((updatedtime == null) ? 0 : updatedtime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaleProduct other = (MaleProduct) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (catagory == null) {
			if (other.catagory != null)
				return false;
		} else if (!catagory.equals(other.catagory))
			return false;
		if (createdby != other.createdby)
			return false;
		if (createdtime == null) {
			if (other.createdtime != null)
				return false;
		} else if (!createdtime.equals(other.createdtime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (Double.doubleToLongBits(offerprice) != Double.doubleToLongBits(other.offerprice))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (sizecolorquantity == null) {
			if (other.sizecolorquantity != null)
				return false;
		} else if (!sizecolorquantity.equals(other.sizecolorquantity))
			return false;
		if (status != other.status)
			return false;
		if (updatedby != other.updatedby)
			return false;
		if (updatedtime == null) {
			if (other.updatedtime != null)
				return false;
		} else if (!updatedtime.equals(other.updatedtime))
			return false;
		return true;
	}


}
