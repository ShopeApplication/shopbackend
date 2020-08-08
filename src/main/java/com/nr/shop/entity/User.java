package com.nr.shop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user",indexes = {@Index(columnList = "id",name = "user_id_index",unique = true),
		                        @Index(columnList = "mobile",name = "user_mobile_index",unique = true),
                                @Index(columnList = "email",name = "user_email_index",unique = true)})
public class User implements Serializable{//columnList is columnname in db table(not the property name)
	
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
	
	@Column(name = "name",nullable = true)
	private String name;
	
	@Column(name = "mobile",nullable = true,length = 10)
	private String mobile;
	
	@Column(name = "alternatemobile",nullable = true,length = 10)
	private String alternatemobile;
	
	@Column(name = "email",nullable = true)
	private String email;
	
	@Column(name = "password",nullable = true)
	private String password;
	
	@Column(name = "role",nullable = false)
	private String role;
	
	@Column(name = "bilingaddress",nullable = true)
	private String bilingaddress;
	
	@Column(name = "shippingaddress",nullable = true)
	private String shippingaddress;
	
	@Column(name = "image",nullable = true)
	private String image;
	
	@Column(name = "status",nullable = false)
	private int status;

	public User(int id, int createdby, Date createdtime, int updatedby, Date updatedtime, String name, String mobile,
			String alternatemobile, String email, String password, String role, String bilingaddress,
			String shippingaddress, String image, int status) {
		super();
		this.id = id;
		this.createdby = createdby;
		this.createdtime = createdtime;
		this.updatedby = updatedby;
		this.updatedtime = updatedtime;
		this.name = name;
		this.mobile = mobile;
		this.alternatemobile = alternatemobile;
		this.email = email;
		this.password = password;
		this.role = role;
		this.bilingaddress = bilingaddress;
		this.shippingaddress = shippingaddress;
		this.image = image;
		this.status = status;
	}

	public User() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlternatemobile() {
		return alternatemobile;
	}

	public void setAlternatemobile(String alternatemobile) {
		this.alternatemobile = alternatemobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBilingaddress() {
		return bilingaddress;
	}

	public void setBilingaddress(String bilingaddress) {
		this.bilingaddress = bilingaddress;
	}

	public String getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternatemobile == null) ? 0 : alternatemobile.hashCode());
		result = prime * result + ((bilingaddress == null) ? 0 : bilingaddress.hashCode());
		result = prime * result + createdby;
		result = prime * result + ((createdtime == null) ? 0 : createdtime.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((shippingaddress == null) ? 0 : shippingaddress.hashCode());
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
		User other = (User) obj;
		if (alternatemobile == null) {
			if (other.alternatemobile != null)
				return false;
		} else if (!alternatemobile.equals(other.alternatemobile))
			return false;
		if (bilingaddress == null) {
			if (other.bilingaddress != null)
				return false;
		} else if (!bilingaddress.equals(other.bilingaddress))
			return false;
		if (createdby != other.createdby)
			return false;
		if (createdtime == null) {
			if (other.createdtime != null)
				return false;
		} else if (!createdtime.equals(other.createdtime))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (shippingaddress == null) {
			if (other.shippingaddress != null)
				return false;
		} else if (!shippingaddress.equals(other.shippingaddress))
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
