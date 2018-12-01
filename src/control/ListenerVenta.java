package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import modelo.Libro;
import vista.LogicaGrafica;

public class ListenerVenta implements ActionListener {

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerVenta(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String isbn = logicaGrafica.obtenerIsbn();
		int unidadesMas=logicaGrafica.obtenerUnidades();
		try {
			if(unidadesMas<=logica.obtenerLibro(logicaGrafica.obtenerIsbn()).getUnidades()) {
				Libro libro = logica.obtenerLibro(logicaGrafica.obtenerIsbn());
				logica.borrarLibro(logicaGrafica.obtenerIsbn());
				libro.setUnidades(libro.getUnidades()-unidadesMas);
				logica.altaLibro(libro);
				logicaGrafica.pintarLista(logica.getLibros());
				logicaGrafica.resetearInformacion();
				logicaGrafica.pintarLibro(logica.obtenerLibro(isbn));
			}
			else {
				logicaGrafica.mostrarMensajeError("Las unidades vendidas superan la cantidad disponible", true);
			}
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
