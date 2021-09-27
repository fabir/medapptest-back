package com.jfsd.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	
	private LocalDateTime fecha_hora;
    private String mensaje;
    private String detalles;
    
	public ExceptionResponse(LocalDateTime fecha_hora, String mensaje, String detalles) {
		super();
		this.fecha_hora = fecha_hora;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}

	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
   
}
