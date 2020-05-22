package com.api.model;

//POJO DNI
public class Dni {
	private int codigoError;
	private String dni;
	private String mensajeError;
	public Dni(int codigoError, String dni, String mensajeError) {
		super();
		this.codigoError = codigoError;
		this.dni = dni;
		this.mensajeError = mensajeError;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public int getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	

}
