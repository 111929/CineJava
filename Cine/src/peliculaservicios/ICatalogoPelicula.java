package peliculaservicios;

public interface ICatalogoPelicula { // vas estar relacionada con la interface al usuario;
  String NOMBRE_RECURSOS ="peliculas.txt"; //una constante que es public static final no es necesario agregarlo;
	void agregarPelicula(String nombrePelicula);
	
	void listarPeliculas();
	
	void buscarPelicula(String buscar);
	
	void IniciarCatalogoPeliculas();
}
