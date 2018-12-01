package control;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import acceso.AlmacenLibreria;
import modelo.Libro;

public class Logica {
	private static final String NOMBRE_BD = "libreriateoria";
	private AlmacenLibreria almacenLibreria;
	
	public Logica() {
		super();
		this.almacenLibreria = new AlmacenLibreria(NOMBRE_BD);
	}

	public void altaLibro(Libro libro) throws IOException {
		assert libro != null;
		almacenLibreria.guardar(libro);
	}

	public boolean borrarLibro(String isbn) throws IOException {
		assert isbn.length()==13:"ISBN incorrecto";
		return almacenLibreria.borrarLibro(isbn);
	}

	public ArrayList<Libro> getLibros() throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		return almacenLibreria.leer();
	}

	public boolean modificarLibro(Libro original,Libro modificado) throws IOException {
		assert original != null && modificado != null:"algun libro para modificar ha llegado null";
		return almacenLibreria.modificarLibro(original,modificado);
	}

	public Libro obtenerLibro(String isbn) throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		assert isbn.length()==13:"longitud isbn incorrecta";
		return almacenLibreria.buscar(isbn);
	}

	public ArrayList<String> obtenerFormatos() throws IOException, SQLException {
		return almacenLibreria.obtenerFormatos();
	}

	public ArrayList<String> obtenerEstados() throws IOException, SQLException {
		return almacenLibreria.obtenerEstados();
	}
}
