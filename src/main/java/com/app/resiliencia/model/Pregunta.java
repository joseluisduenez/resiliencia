package com.app.resiliencia.model;

import java.util.List;

public class Pregunta {
	List<Respuesta> respuesta;
	private Integer id;
	private String name;
	public List<Respuesta> getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(List<Respuesta> respuesta) {
		this.respuesta = respuesta;
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
