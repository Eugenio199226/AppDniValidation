package com.api.User;

import org.junit.jupiter.api.Test;

import com.api.model.Dni;
import com.api.utils.DniValidator;

public class TestValidaciones {
	DniValidator dniValidador = new DniValidator();
	@Test
	public void TestdniValido() 
	{
		Dni dniValidado = dniValidador.validacion("11534197L");
		System.out.println(dniValidado.getCodigoError()+" "+dniValidado.getDni()+" "+dniValidado.getMensajeError());

	}
	@Test
	public void TestnieValido() 
	{
		Dni nieValidado = dniValidador.validacion("Y2735016P");	
		System.out.println(nieValidado.getCodigoError()+" "+nieValidado.getDni()+" "+nieValidado.getMensajeError());
	}

}
