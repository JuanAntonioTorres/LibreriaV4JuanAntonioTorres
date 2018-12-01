package acceso;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.rowset.CachedRowSetImpl;
import control.Errores;
import modelo.Libro;

public class AlmacenLibreria {

	private String usuario = "root";
	private String contraseña = "";
	private String nombreDB;
	private String driver = "com.mysql.jdbc.Driver";
	private static Connection conexion = null;
	
	public AlmacenLibreria(String nombreBaseDatos) {
		this.nombreDB = "jdbc:mysql://localhost/"+nombreBaseDatos;
	}

	private Connection abrirConexion() throws IOException {
		if (conexion == null) {
			try {
				Runtime.getRuntime().addShutdownHook(new CerrarConexion());
				Class.forName(driver);
				conexion = (Connection) DriverManager.getConnection(nombreDB, usuario, contraseña);
				conexion.setAutoCommit(false);
				System.out.println("Abriendo conexion...");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return conexion;
	}
	
	class CerrarConexion extends Thread {
		@Override
		public void run() {
			try {
				abrirConexion().close();
				System.out.println("... cerrando conexion");
			} catch (SQLException | IOException e) {
				new control.Errores(e);
			}
		}
	}
	
	private boolean commit(int resultado) throws SQLException {
		if (resultado == 1) {
			conexion.commit();
			return true;
		} else {
			conexion.rollback();
			return false;
		}
	}
	
	public boolean ejecutarUpdate(String sql) throws IOException, SQLException {
		abrirConexion();
		Statement myStatement = (Statement) conexion.createStatement();
		int resultado = myStatement.executeUpdate(sql);
		boolean retorno =  commit(resultado);
		CerrarConexion.currentThread();
		return retorno;
	}

	
	public boolean guardar(Libro libro) throws IOException {
		try {
			System.out.println(sqlInsertarLibro(libro));
			return ejecutarUpdate(sqlInsertarLibro(libro));
		} catch (SQLException e) {
			new control.Errores(e);
			return false;
		}
	}
	
	public ArrayList<Libro> leer() throws IOException, SQLException, IllegalArgumentException, IllegalAccessException, SecurityException {
		ArrayList<Libro> libros = new ArrayList<>();
		abrirConexion();
		CachedRowSet cachedRowSet = new CachedRowSetImpl();
		cachedRowSet.populate(conexion.prepareStatement(sqlObtenerLibros()).executeQuery());
		while(cachedRowSet.next()) {
			libros.add(crearLibroDesdeResultSet(cachedRowSet.getOriginalRow()));
		}
		cachedRowSet.close();
		return libros;
	}
	
	public ArrayList<String> obtenerFormatos() throws IOException, SQLException {
		ArrayList<String> formatos = new ArrayList<>();
		abrirConexion();
		CachedRowSet cachedRowSet = new CachedRowSetImpl();
		cachedRowSet.populate(conexion.prepareStatement(sqlObtenerFormatos()).executeQuery());
		while(cachedRowSet.next()) {
			formatos.add(cachedRowSet.getString(1));
			System.out.println(cachedRowSet.getString(1));
		}
		cachedRowSet.close();
		return formatos;
	}
	
	public ArrayList<String> obtenerEstados() throws IOException, SQLException {
		ArrayList<String> estados = new ArrayList<>();
		abrirConexion();
		CachedRowSet cachedRowSet = new CachedRowSetImpl();
		cachedRowSet.populate(conexion.prepareStatement(sqlObtenerEstados()).executeQuery());
		while(cachedRowSet.next()) {
			estados.add(cachedRowSet.getString(1));
		}
		cachedRowSet.close();
		return estados;
	}

	public Libro buscar(String isbn) throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		abrirConexion();
		return crearLibroDesdeResultSet(conexion.createStatement().executeQuery(sqlBuscarLibro(isbn)));
	}
	
	private Libro crearLibroDesdeResultSet(ResultSet resultSet) throws IOException, SQLException, IllegalArgumentException, IllegalAccessException, SecurityException {
		abrirConexion();
		ArrayList<Object> datosLibro = new ArrayList<>();
		if(resultSet.first()) {
			for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
				datosLibro.add(resultSet.getObject(i));
			}
			return new Libro(datosLibro);
		}
		return null;
	}

	public boolean borrarLibro(String isbn) throws IOException {
		try {
			return ejecutarUpdate(sqlBorrarLibro(isbn));
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean modificarLibro(Libro original, Libro modificado) throws IOException {
		try {
			return ejecutarUpdate(sqlModificarLibro(original, modificado));
		} catch (SQLException e) {
			e.printStackTrace();
			new Errores(e);
			return false;
		}
	}
	
	private final String sqlInsertarLibro(Libro obLibro) {
		return "INSERT INTO `libro` (`ISBN`, `titulo`, `autor`, `tema`, `paginas`, `formato`, `estado`, `editorial`, `unidades`) VALUES ('"
				+ obLibro.getIsbn()
				+ "' , '"
				+ obLibro.getTitulo()
				+ "' , '"
				+ obLibro.getAutor()
				+ "' , '"
				+ obLibro.getTema()
				+ "' , '"
				+ obLibro.getNumPaginas()
				+ "' , '"
				+ obLibro.getFormato()
				+ "' , '"
				+ obLibro.getEstado()
				+ "' , '"
				+ obLibro.getEditorial()
				+ "' , '"
				+ obLibro.getUnidades()
				+"');";
	}

	private final String sqlBorrarLibro(String isbn) {
		return "DELETE FROM `libro` WHERE `ISBN` = '" + isbn + "'";
	}

	private final String sqlBuscarLibro(String isbn) {
		return "SELECT * FROM `libro` WHERE `ISBN` = '"+ isbn + "'";
	}

	private final static String sqlObtenerLibros() {
		return "SELECT * FROM `libro` ";
	}

	private final String sqlModificarLibro(Libro original, Libro modificado) {
		return "UPDATE `libro` SET "
				+ "`ISBN`= '" + original.getIsbn()
				+ "' ,`titulo`= '" + modificado.getTitulo()
				+ "' ,`autor`= '" + modificado.getAutor() 
				+ "' ,`tema`= '" + modificado.getTema() 
				+ "' ,`paginas`= '" + modificado.getNumPaginas() 
				+ "' ,`formato`= '" + modificado.getFormato()
				+ "' ,`estado`= '" + modificado.getEstado() 
				+ "' ,`editorial`= '" + modificado.getEditorial()
				+ "' ,`unidades`= '" + modificado.getUnidades()
				+ "'  WHERE `ISBN` = '" + original.getIsbn() + "'";
	}

	private final String sqlObtenerFormatos() {
		return "SELECT `formato` FROM `formato` WHERE 1";
	}

	private final String sqlObtenerEstados() {
		return "SELECT `estado` FROM `estado` WHERE 1";
	}
	

}
