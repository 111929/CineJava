package accesodatos;

import excepciones.*;

import java.util.List;

import domain.*;

public interface IAccesoDatos {

    boolean existe (String nombreRecursos) throws AccesoDatosEx;
 
      List<Peliculas> listar(String nombreRecursos) throws LecturaDatosEx;
      void escribir(Peliculas pelicula,String nombreRecursos,boolean anexar) throws EscrituraDatosEx;
      String buscar(String nombreRecursos,String buscar)throws LecturaDatosEx;
      void crear(String	nombreRecursos)throws AccesoDatosEx;
      void borrar(String nombreRecursos)throws AccesoDatosEx;
      
}
