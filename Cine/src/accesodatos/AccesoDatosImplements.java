package accesodatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


import domain.Peliculas;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;

public class AccesoDatosImplements implements IAccesoDatos {

	@Override
	public boolean existe(String nombreRecursos)  { //como es de tipo exepcion se debe dejar el throws si seria runtime se puede quitar
		File archivo= new File(nombreRecursos);
	 return 	archivo.exists();
		
	}

	@Override
	public List<Peliculas> listar(String nombreRecursos) throws LecturaDatosEx {
		var archivo= new File(nombreRecursos);
		List<Peliculas> peliculas= new ArrayList<>();
		
		try {
			var entrada= new BufferedReader(new FileReader(archivo));
			String linea= null;
			linea=entrada.readLine();
			while(linea!=null) { // se pregunta si la linea es distinta a null entonces entra al bloque y se agrega una pelicula
				var pelicula = new Peliculas(linea);
			   peliculas.add(pelicula);
			   linea = entrada.readLine();
			}
			entrada.close(); // se cierra el flujo;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LecturaDatosEx("Exepcion a listar peliculas"+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Exepcion a listar peliculas"+e.getMessage());
			
		}
       return peliculas;
	}

	@Override
	public void escribir(Peliculas pelicula, String nombreRecursos, boolean anexar) throws EscrituraDatosEx {
		var archivo= new File(nombreRecursos);
		try {
			var salida= new PrintWriter (new FileWriter(archivo, anexar));
			salida.println(pelicula.toString());
			salida.close();
			System.out.println("Se ha escrito informacion al archivo" + pelicula);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EscrituraDatosEx("Exepcion a escribir Peliculas"+e.getMessage());
		}
		
		
	}

	@Override
	public String buscar(String nombreRecursos, String buscar) throws LecturaDatosEx {
		var archivo= new File(nombreRecursos);
		String resultado=null;
		try {
			var entrada= new BufferedReader(new FileReader(archivo));
			String linea=null;
			linea= entrada.readLine();
			int indice=1;
			while(linea!= null) {
				if(buscar!= null && buscar.equalsIgnoreCase(linea)) {
					resultado="pelicula" + linea +"encontrada en el indice "+ indice;
					break; //se encuentra la pelicula y se realiza un ruptura
				}
				linea= entrada.readLine();
				indice++; // si no se encuentra en la 1era linea leemos la siguiente linea
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Exepcion a buscar pelicula"+e.getMessage());
		} catch (IOException e) {
			
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar pelicula:" + ex.getMessage());
		}
		
		return resultado;
	}

	@Override
	public void crear(String nombreRecursos) throws AccesoDatosEx {
		var archivo=  new File(nombreRecursos);
		try {
			var salida= new PrintWriter(new FileWriter(archivo));
			System.out.println("Se ha creado el archivo");
		} catch (IOException e) {
			
			e.printStackTrace();
			throw new AccesoDatosEx("Exepcion al crear Archivo"+e.getMessage());
		}
		
	}

	@Override
	public void borrar(String nombreRecursos) throws AccesoDatosEx {
		var archivo= new File(nombreRecursos);
		if(archivo.exists()) 
			archivo.delete();
		System.out.println("se ha creado un archivo");
		
	}

}
