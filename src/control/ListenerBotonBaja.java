package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import vista.LogicaGrafica;

public class ListenerBotonBaja implements ActionListener{
	Logica logica;
	LogicaGrafica logicaGrafica;

	public ListenerBotonBaja(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			logica.borrarLibro(logicaGrafica.obtenerIsbn());
			logicaGrafica.pintarLista(logica.getLibros());
		} catch (IOException | IllegalArgumentException | IllegalAccessException | SecurityException | SQLException e1) {
			e1.printStackTrace();
		}
		logicaGrafica.resetearInformacion();
		logicaGrafica.mostrarMensajeError("libro eliminado", false);
	}

}
