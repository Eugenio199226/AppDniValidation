package DniEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

//Entity DNI
@Entity
public class DniEntity {
	@Id
	private int codigoError;
	@JsonProperty("dni")
	private String dni;
	private String mensajeError;
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
	public DniEntity(int codigoError, String dni, String mensajeError) {
		super();
		this.codigoError = codigoError;
		this.dni = dni;
		this.mensajeError = mensajeError;
	}



	
}
