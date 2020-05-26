package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Repository.DniValidadorRepository;
import com.api.Utils.DniValidator;
import com.api.model.Dni;

import DniEntity.DniEntity;

//Anotación que indica a spring boot que es un controlador
@RestController
//Raiz de la dirección de la api
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private DniValidadorRepository dnirep;
	
	DniValidator dniValidador = new DniValidator();
	//Valida el dni pasado mediante Json
	@PostMapping("/validar")
	public ResponseEntity<DniEntity> validarDni(@RequestBody Dni dni) 
	{
		Dni validado = dniValidador.validacion(dni.getDni());
		DniEntity dniResultado=new DniEntity(validado.getCodigoError(),validado.getDni(),validado.getMensajeError());
		return  ResponseEntity.ok().body(dniResultado);
	}
	

}
