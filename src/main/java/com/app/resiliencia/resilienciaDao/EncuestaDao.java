package com.app.resiliencia.resilienciaDao;

import java.util.List;

import com.app.resiliencia.model.Catalog;
import com.app.resiliencia.model.Encuesta;

public interface EncuestaDao {
	public Catalog getDataById(Integer id);

	public Encuesta getRows();
	public void removeRow(Integer id);
	public void addRow(Catalog p);
	public Integer getId() ;
}
