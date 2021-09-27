package com.jfsd.dto;

import java.util.List;

import com.jfsd.model.Consulta;
import com.jfsd.model.Examen;
/**
 * Created by fromero on 27/12/2020.
 */
public class ConsultaListaExamenDTO {

	private Consulta consulta;
	private List<Examen> listaExamen;
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public List<Examen> getListaExamen() {
		return listaExamen;
	}
	public void setListaExamen(List<Examen> listaExamen) {
		this.listaExamen = listaExamen;
	}
	
}
