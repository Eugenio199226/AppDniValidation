package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Repository.DniValidadorRepository;
import com.api.entity.DniEntity;
import com.api.model.Dni;
import com.api.utils.DniValidator;

//Dirección permitida
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
