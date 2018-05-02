package com.app.resiliencia.model;

import java.io.Serializable;
import java.util.Date;

 

 
 

public class User  implements Serializable {


 
    private Integer id;
 
    private Date createdAt;
     private String name;
     private String email;
	 private String password;
	 private Integer role;
	 private String since;
	 private Integer status; 
     public String getSince() {
		return since;
	}
	public void setSince(String since) {
		this.since = since;
	}
 
  
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
    
    
    
}
