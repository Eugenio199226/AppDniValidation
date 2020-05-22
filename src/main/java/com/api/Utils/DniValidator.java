package com.api.Utils;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.api.model.Dni;

public class DniValidator {
	public Dni validacionDni(String dni) 
	{
		Dni resultado = new Dni(3,"No Validado","");
    	Pattern p = Pattern.compile("[0-9]{8}[A-Z a-z]");
    	Matcher mat = p.matcher(dni);
    	//Check format
    	if(mat.matches()) 
    	{
    		try 
    		{
    			System.out.println("Formato Dni Valido");
        		System.out.println("Calculando letra del Dni.....");
        		//get letter
        		String letra=dni.substring(dni.length()-1);
        		//get number
        		String numeros= dni.substring(0,dni.length()-1);
    			int num = Integer.parseInt(numeros);
    			//Validation of letter and numbers
    			if(Boolean.TRUE.equals(comparador(letra,num))) 
    			{
    				System.out.println("Dni Valido.");
    				resultado.setCodigoError(0);
    				resultado.setDni(dni);
    				resultado.setMensajeError("Valido");
    				
    				return resultado;
    			}else 
    			{
    				System.out.println("La letra no es correcta");
    				resultado.setCodigoError(2);
    				resultado.setDni(dni);
    				resultado.setMensajeError("Letra Incorrecta");
    				
    				
    				return resultado;
    			}
    			
    		}catch(NumberFormatException  e) 
    		{
    			System.out.println("No se ha podido generar un int con el string");
    			resultado.setCodigoError(3);
				resultado.setDni(dni);
				resultado.setMensajeError("No se ha Podido extraer un numero");
				
    		}
    	}else 
    	{
    		System.out.println("Formato Dni Incorrecto");
    		resultado.setCodigoError(1);
			resultado.setDni(dni);
			resultado.setMensajeError("Formato Dni Incorrecto");
			
    	}
		return resultado;
		
	}
	 public Boolean comparador(String letra,int numero) 
	    {
		 	//value between 0-22
		 	int valorCaculado=numero%23;
		 	Hashtable<String, Integer> dniLetras= new Hashtable<String, Integer>();
		 	dniLetras.put("T", 0);
		 	dniLetras.put("R", 1);
		 	dniLetras.put("W", 2);
		 	dniLetras.put("A", 3);
		 	dniLetras.put("G", 4);
		 	dniLetras.put("M", 5);
		 	dniLetras.put("Y", 6);
		 	dniLetras.put("F", 7);
		 	dniLetras.put("P", 8);
		 	dniLetras.put("D", 9);
		 	dniLetras.put("X", 10);
		 	dniLetras.put("B", 11);
		 	dniLetras.put("N", 12);
		 	dniLetras.put("J", 13);
		 	dniLetras.put("Z", 14);
		 	dniLetras.put("S", 15);
		 	dniLetras.put("Q", 16);
		 	dniLetras.put("V", 17);
		 	dniLetras.put("H", 18);
		 	dniLetras.put("L", 19);
		 	dniLetras.put("C", 20);
		 	dniLetras.put("K", 21);
		 	dniLetras.put("E", 22);
		 	Iterator<Map.Entry<String, Integer>> itr = dniLetras.entrySet().iterator();
		 	Map.Entry<String, Integer> entry = null;
		 	//Search number get letter associate with number and compare with String letra
		 	while(itr.hasNext()) 
		 	{
		 		entry = itr.next();
	            //if this entry value is equals to the value
	            if(entry.getValue().equals(valorCaculado)&&entry.getKey().equals(letra)){
	            	
	                return true;
	            }
			
		 	}
		 	return false;
	    }
	

}
