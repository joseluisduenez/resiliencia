package com.app.resiliencia.resilienciaDao;

import java.util.List;

import com.app.resiliencia.model.Catalog;

public interface PropertyDao {
	public Catalog getDataById(Integer id);

	public List<Catalog> getProperties();
	public void removeProperty(Integer id);
	public void addProperty(Catalog p);
}
