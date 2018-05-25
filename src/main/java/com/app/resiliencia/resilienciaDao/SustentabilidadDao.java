package com.app.resiliencia.resilienciaDao;

import java.util.List;

import com.app.resiliencia.model.Catalog;
import com.app.resiliencia.model.GeneralData;
import com.app.resiliencia.model.Sustentabilidad;

public interface SustentabilidadDao {

	public Sustentabilidad getDataByUserId(Integer userId);
	public void update(Sustentabilidad Sustentabilidad);
	public void add(Sustentabilidad Sustentabilidad);

}
