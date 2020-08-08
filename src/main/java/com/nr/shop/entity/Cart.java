package com.nr.shop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cart")
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    private int userId;
    
    private int productId;
	
	@CreationTimestamp
	private Date createdtime;
	
	@UpdateTimestamp
	private Date updatedtime;
	
	@Column(name = "status",nullable = false)
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public Date getUpdatedtime() {
		return updatedtime;
	}

	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Cart(int id, int userId, int productId, Date createdtime, Date updatedtime, int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.createdtime = createdtime;
		this.updatedtime = updatedtime;
		this.status = status;
	}

	public Cart(int userId, int productId, int status) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.status = status;
	}

	public Cart() {
		super();
	}
	
}
