package com.app.resiliencia.model;

import java.util.List;

public class Area {

	List <SubArea> subarea;
	private Integer id;
	private String name;
	public List<SubArea> getSubarea() {
		return subarea;
	}
	public void setSubarea(List<SubArea> subarea) {
		this.subarea = subarea;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
