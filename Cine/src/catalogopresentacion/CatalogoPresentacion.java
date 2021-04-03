package catalogopresentacion;

import java.util.Scanner;

import peliculaservicios.CatalogoPeliculasImplements;
import peliculaservicios.ICatalogoPelicula;

public class CatalogoPresentacion {
 public static void main(String[]args) {
	 var opcion= -1;
	 var sc= new Scanner (System.in);
	 ICatalogoPelicula catalogo= new CatalogoPeliculasImplements();
	 while(opcion!=0) {
		 System.out.println("Elige una opcion: \n"
				 + "1. Iniciar Catalogo de pelicula: \n"
				 + "2.Agregar Pelicula:\n"
				 + "3.Listar pelicula: \n"
				 + "4. Buscar pelicula:\n"
				 + "0. Salir");
		   opcion= Integer.parseInt(sc.nextLine());// es recomendable ya que realiza un salto de linea
		   switch(opcion) {
		   case 1: catalogo.IniciarCatalogoPeliculas(); break;
		   
		   case 2:  System.out.println("introducir el nombre de la pelicula");
		    var nombrePelicula= sc.nextLine();
			   catalogo.agregarPelicula(nombrePelicula); 
			   break;
		   case 3: catalogo.listarPeliculas(); break;
		   
		   case 4: System.out.println("que pelicula queres buscar");
		   var nombreBuscar= sc.nextLine();
		   catalogo.buscarPelicula(nombreBuscar); 
		   break;
		   case 0: 
			   System.out.println("hasta pronto");
			   break;
			   default:
				   System.out.println("opcion no reconocida");
				   break;
		   }
	 }
 }
}
