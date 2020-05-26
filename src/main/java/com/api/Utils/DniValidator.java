package com.api.Utils;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.api.model.Dni;

public class DniValidator {
	public Dni validacion(String valor) 
	{
		Pattern pDni = Pattern.compile("[0-9]{8}[A-Z a-z]");
		Pattern pNie = Pattern.compile("[X-Z x-z][0-9]{7}[A-Z a-z]");
		Matcher matDni = pDni.matcher(valor);
		Matcher matNie = pNie.matcher(valor);
		if(matDni.matches()) 
		{
			return validacionDni(valor);
		}else if(matNie.matches()) 
		{
			return validadorNie(valor);
		}else 
		{
			return new Dni(1,"Formato Documento Incorrecto",valor);
		}
	}
	private Dni validacionDni(String dni) 
	{
		Dni resultado = new Dni(3,"No Validado","");
    	//Check format
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
    			if(Boolean.TRUE.equals(comparadorDni(letra,num))) 
    			{
    				resultado.setCodigoError(0);
    				resultado.setDni(dni);
    				resultado.setMensajeError("Dni Valido");
    				
    				return resultado;
    			}else 
    			{
    				resultado.setCodigoError(2);
    				resultado.setDni(dni);
    				resultado.setMensajeError("Letra del Dni Incorrecta");
    				
    				
    				return resultado;
    			}
    			
    		}catch(NumberFormatException  e) 
    		{
    			resultado.setCodigoError(3);
				resultado.setDni(dni);
				resultado.setMensajeError("No se ha Podido extraer un numero del Dni");
				
    		}
    		return resultado;
    	}

		
	

	private Boolean comparadorDni(String letra,int numero) 
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
	 
	private Dni validadorNie(String nie) 
		{
		 	Dni resultado = new Dni(7,"Nie No Validado","");

	    	//Check format
	    		try 
	    		{
	    			System.out.println("Formato Nie Valido");
	        		System.out.println("Calculando letra del Nie.....");
	        		//get letter
	        		String letra=nie.substring(nie.length()-1);
	        		String letraex=nie.substring(0,1);
	        		//get number
	        		String numeros= nie.substring(1,nie.length()-1);

	    			//Validation of letter and numbers
	    			if(Boolean.TRUE.equals(comparadorNie(letra,numeros,letraex))) 
	    			{
	    				resultado.setCodigoError(4);
	    				resultado.setDni(nie);
	    				resultado.setMensajeError("Nie Valido");
	    				return resultado;
	    				
	    			}else 
	    			{
	    				resultado.setCodigoError(6);
	    				resultado.setDni(nie);
	    				resultado.setMensajeError("La letra del Nie no es valida");
	    				return resultado;
	    			}
	    			
	    		}catch(NumberFormatException  e) 
	    		{
	    			resultado.setCodigoError(6);
    				resultado.setDni(nie);
    				resultado.setMensajeError("No se ha podido convertir el string a int");
    				return resultado;
	    		}
	    	}
		
	private Boolean comparadorNie(String letra,String numeros,String letraEx) 
		    {
			 	Hashtable<String, Integer> nifLetras= new Hashtable<String, Integer>();
			 	nifLetras.put("X", 0);
			 	nifLetras.put("Y", 1);
			 	nifLetras.put("Z", 2);
			 Iterator<Map.Entry<String, Integer>> itr2 = nifLetras.entrySet().iterator();
			 	Map.Entry<String, Integer> entry = null;
			 	while(itr2.hasNext()) 
			 	{
			 		entry = itr2.next();
			 		
			 		if(entry.getKey().equals(letraEx)){
		            	
			 			numeros=entry.getValue()+numeros;
		            }
			 	}
			 	//value between 0-22
			 	int num = Integer.parseInt(numeros);
			 	int valorCaculado=num%23;

			 	
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
