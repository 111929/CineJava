package peliculaservicios;

import accesodatos.AccesoDatosImplements;
import accesodatos.IAccesoDatos;
import domain.Peliculas;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;

public class CatalogoPeliculasImplements  implements ICatalogoPelicula{
 private final IAccesoDatos datos;
 
 


	public CatalogoPeliculasImplements() {
	
	this.datos = new AccesoDatosImplements()  ;//esto en parte es lo que resuelve el framework spring a traves de inyeccion dependencias;
}



	@Override
	public void agregarPelicula(String nombrePelicula) {
		Peliculas pelicula= new Peliculas(nombrePelicula);
		boolean anexar= false;
		try {
			anexar= datos.existe(NOMBRE_RECURSOS);
			datos.escribir(pelicula, NOMBRE_RECURSOS, anexar);
		} catch (AccesoDatosEx e) {
			System.out.println("error al acceso de datos");
			e.printStackTrace(System.out);
		}
		
	}

	@Override
	public void listarPeliculas() {
		try {
			var pelicula= this.datos.listar(NOMBRE_RECURSOS);
			for(var peliculas:pelicula) {
				System.out.println("pelicula: "+ peliculas);
			}
		} catch (LecturaDatosEx e) {
			System.out.println("error al acceso de datos");
			e.printStackTrace(System.out);
		}
		
		
	}

	@Override
	public void buscarPelicula(String buscar) {
		String  resultado= null;
		try {
			resultado= this.datos.buscar(NOMBRE_RECURSOS, buscar);
		} catch (LecturaDatosEx e) {
			System.out.println("Error acceso Datos");
			e.printStackTrace();
		}
		System.out.println("Resultado: " + resultado);
	}

	@Override
	public void IniciarCatalogoPeliculas() {
		try {
			if(this.datos.existe(NOMBRE_RECURSOS)) {
				datos.borrar(NOMBRE_RECURSOS);
				
			}else {
				datos.crear(NOMBRE_RECURSOS);
			}
		} catch (AccesoDatosEx e) {
			System.out.println("Error al iniciar catalogo de peliculas");
			e.printStackTrace();
		}
		
	}

}
