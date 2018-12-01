package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import modelo.Libro;
import vista.LogicaGrafica;

public class ListenerBotonModificar implements ActionListener{

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerBotonModificar(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logicaGrafica.resetearMensajeError();
		try {
			Libro libroOriginal = logica.obtenerLibro((logicaGrafica.obtenerIsbn()));
			Libro libroModificado = obtenerLibroModificado();
			logica.modificarLibro(libroOriginal, libroModificado);
			logicaGrafica.resetearInformacion();
			logicaGrafica.pintarLista(logica.getLibros());
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IOException
				| SQLException e3) {
			logicaGrafica.mostrarMensajeError("libro modificado", false);
			e3.printStackTrace();
		}
	}

	private Libro obtenerLibroModificado() throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		return logicaGrafica.crearLibro(logica.getLibros(),false);
	}

}
