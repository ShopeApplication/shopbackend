package com.nr.shop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user_message")
public class UserMessage implements Serializable{
	
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
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String subject;
	
	private String message;
	
	private int status;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UserMessage() {
		super();
	}

	public UserMessage(int id, int createdby, Date createdtime, int updatedby, Date updatedtime, String name,
			String email, String mobile, String subject, String message, int status) {
		super();
		this.id = id;
		this.createdby = createdby;
		this.createdtime = createdtime;
		this.updatedby = updatedby;
		this.updatedtime = updatedtime;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.subject = subject;
		this.message = message;
		this.status = status;
	}
	
    
}
